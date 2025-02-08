@file:Suppress("FunctionName")

package dev.intsuc.datapacks

import kotlin.reflect.KProperty

class FunctionContext internal constructor(internal val name: String) {
    private val commands: MutableList<String> = mutableListOf()
    internal var nextFunction: Int = 0
    internal var nextScore: Int = 0

    operator fun String.not() = +"# $this"
    operator fun invoke() = +"function $name"
    operator fun Function.invoke() = +"function $name"
    fun say(message: String) = +"say $message"

    internal fun build(block: (String) -> Unit) = commands.forEach(block)

    internal fun add(command: String): Unit = run { commands.add(command) }
    private operator fun String.unaryPlus() = add(this)
}

sealed interface Tag {
    override fun toString(): String
}

data class ByteTag(val value: Byte) : Tag {
    override fun toString(): String = "${value}b"
}

data class ShortTag(val value: Short) : Tag {
    override fun toString(): String = "${value}s"
}

data class IntTag(val value: Int) : Tag {
    override fun toString(): String = "$value"
}

data class LongTag(val value: Long) : Tag {
    override fun toString(): String = "${value}l"
}

data class FloatTag(val value: Float) : Tag {
    override fun toString(): String = "${value}f"
}

data class DoubleTag(val value: Double) : Tag {
    override fun toString(): String = "${value}d"
}

data class ByteArrayTag(val elements: List<Byte>) : Tag {
    override fun toString(): String = elements.joinToString("[B;", ",", "]") { "${it}b" }
}

data class StringTag(val value: String) : Tag {
    override fun toString(): String = "\"${value.replace("\"", "\\\"")}\""
}

data class ListTag(val elements: List<Tag>) : Tag {
    override fun toString(): String = elements.joinToString("[", ",", "]")
}

data class CompoundTag(val elements: Map<String, Tag>) : Tag {
    override fun toString(): String = elements.entries.joinToString("{", ",", "}") { (key, value) -> "$key:$value" }
}

data class IntArrayTag(val elements: List<Int>) : Tag {
    override fun toString(): String = elements.joinToString("[I;", ",", "]")
}

data class LongArrayTag(val elements: List<Long>) : Tag {
    override fun toString(): String = elements.joinToString("[L;", ",", "]") { "${it}l" }
}

class Score internal constructor(private val c: FunctionContext, val name: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Score = this
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Score) = +"scoreboard players operation $this _ = $value _"
    infix fun `=`(source: Score) = if (this !== source) +"scoreboard players set $this _ = $source _" else Unit
    operator fun plusAssign(source: Score) = +"scoreboard players operation $this _ += $source _"
    operator fun minusAssign(source: Score) = +"scoreboard players operation $this _ -= $source _"
    operator fun timesAssign(source: Score) = +"scoreboard players operation $this _ *= $source _"
    operator fun divAssign(source: Score) = +"scoreboard players operation $this _ /= $source _"
    operator fun remAssign(source: Score) = +"scoreboard players operation $this _ %= $source _"
    infix fun `min=`(source: Score) = +"scoreboard players operation $this _ < $source _"
    infix fun `max=`(source: Score) = +"scoreboard players operation $this _ > $source _"
    infix fun swap(source: Score) = +"scoreboard players operation $this _ >< $source _"
    infix fun `=`(value: Int) = +"scoreboard players set $this _ $value"
    operator fun plusAssign(value: Int) = +"scoreboard players add $this _ $value"
    operator fun minusAssign(value: Int) = +"scoreboard players remove $this _ $value"
    operator fun timesAssign(value: Int) = useTemp { it `=` value; this *= it }
    operator fun divAssign(value: Int) = useTemp { it `=` value; this /= it }
    operator fun remAssign(value: Int) = useTemp { it `=` value; this %= it }
    infix fun `min=`(value: Int) = useTemp { it `=` value; this `min=` it }
    infix fun `max=`(value: Int) = useTemp { it `=` value; this `max=` it }
    override fun toString(): String = "#$name"

    private inline fun useTemp(block: (Score) -> Unit) {
        val score = Score(c, c.nextScore++.toString())
        block(score)
        c.nextScore--
    }

    private operator fun String.unaryPlus() = c.add(this)
}

class ScoreProvider internal constructor(private val c: FunctionContext, private val value: Int) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Score = Score(c, property.name).also {
        c.add("scoreboard players set $it _ $value")
    }
}

fun FunctionContext.score(value: Int) = ScoreProvider(this, value)

class Function internal constructor(
    val name: String,
    internal val block: FunctionContext.() -> Unit,
) {
    init {
        entries.add(this)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Function = this
    override fun toString(): String = name

    companion object {
        internal val entries: MutableList<Function> = mutableListOf()
    }
}

class FunctionProvider internal constructor(private val block: FunctionContext.() -> Unit) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Function = Function(functionName(thisRef, property), block)
}

fun function(block: FunctionContext.() -> Unit): FunctionProvider = FunctionProvider(block)

fun FunctionContext.function(block: FunctionContext.() -> Unit): Function = Function("$name/${nextFunction++}", block)

class MetaFunctionProvider1<A1> internal constructor(private val block: FunctionContext.(A1) -> Unit) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): F = F(functionName(thisRef, property))
    inner class F(private val name: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): F = this
        operator fun invoke(a1: A1): Function = Function("$name/$a1") { block(a1) }
    }
}

fun <A1> metaFunction(block: FunctionContext.(A1) -> Unit): MetaFunctionProvider1<A1> = MetaFunctionProvider1(block)

class MetaFunctionProvider2<A1, A2> internal constructor(private val block: FunctionContext.(A1, A2) -> Unit) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): F = F(functionName(thisRef, property))
    inner class F(private val name: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): F = this
        operator fun invoke(a1: A1, a2: A2): Function = Function("$name/$a1/$a2") { block(a1, a2) }
    }
}

fun <A1, A2> metaFunction(block: FunctionContext.(A1, A2) -> Unit): MetaFunctionProvider2<A1, A2> = MetaFunctionProvider2(block)

private fun functionName(thisRef: Any?, property: KProperty<*>): String = "${thisRef?.javaClass?.name?.let { "$it/" } ?: ""}${property.name}".snakecase()

private fun String.snakecase(): String {
    val builder = StringBuilder()
    for (i in indices) {
        val c = this[i]
        if (c.isUpperCase() && i > 0) {
            builder.append('_')
        }
        builder.append(c.lowercase())
    }
    return builder.toString()
}
