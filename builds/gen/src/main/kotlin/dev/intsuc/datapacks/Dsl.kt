@file:Suppress("FunctionName")

package dev.intsuc.datapacks

import kotlin.collections.plus
import kotlin.reflect.KProperty

class FunctionContext internal constructor(internal val name: String) {
    private val commands: MutableList<String> = mutableListOf()
    internal var nextFunction: Int = 0
    internal var nextScore: Int = 0

    operator fun String.not() = +"# $this"
    operator fun invoke() = +"function $name"
    operator fun Function.invoke() = +"function $name"
    fun say(message: String) = +"say $message"

    fun Storage.merge(nbt: CompoundNbt) = +"data merge storage $this $nbt"
    fun Storage.merge(block: CompoundNbtBuilder.() -> Unit) = merge(CompoundNbtBuilder().apply(block).build())
    fun NbtPath.get() = add("data get $this")
    fun NbtPath.get(scale: Double) = add("data get $this $scale")
    fun NbtPath.remove() = add("data remove $this")
    fun NbtPath.append(from: NbtPath, stringify: Boolean = false) = add("data modify $this append ${if (stringify) "string" else "from"} $from")
    fun NbtPath.append(value: Nbt) = add("data modify $this append value $value")
    fun NbtPath.append(block: CompoundNbtBuilder.() -> Unit) = append(CompoundNbtBuilder().apply(block).build())
    fun NbtPath.prepend(from: NbtPath, stringify: Boolean = false) = add("data modify $this prepend ${if (stringify) "string" else "from"} $from")
    fun NbtPath.prepend(value: Nbt) = add("data modify $this prepend value $value")
    fun NbtPath.prepend(block: CompoundNbtBuilder.() -> Unit) = prepend(CompoundNbtBuilder().apply(block).build())
    fun NbtPath.insert(index: Int, from: NbtPath, stringify: Boolean = false) = add("data modify $this insert $index ${if (stringify) "string" else "from"} $from")
    fun NbtPath.insert(index: Int, value: Nbt) = add("data modify $this insert $index value $value")
    fun NbtPath.insert(index: Int, block: CompoundNbtBuilder.() -> Unit) = insert(index, CompoundNbtBuilder().apply(block).build())
    fun NbtPath.set(from: NbtPath, stringify: Boolean = false) = add("data modify $this set ${if (stringify) "string" else "from"} $from")
    fun NbtPath.set(value: Nbt) = add("data modify $this set value $value")
    fun NbtPath.set(block: CompoundNbtBuilder.() -> Unit) = set(CompoundNbtBuilder().apply(block).build())
    fun NbtPath.merge(from: NbtPath, stringify: Boolean = false) = add("data modify $this merge ${if (stringify) "string" else "from"} $from")
    fun NbtPath.merge(value: Nbt) = add("data modify $this merge value $value")
    fun NbtPath.merge(block: CompoundNbtBuilder.() -> Unit) = merge(CompoundNbtBuilder().apply(block).build())

    internal fun build(block: (String) -> Unit) = commands.forEach(block)

    internal fun add(command: String): Unit = run { commands.add(command) }
    private operator fun String.unaryPlus() = add(this)
}

sealed interface Nbt {
    override fun toString(): String
}

data class ByteNbt(val value: Byte) : Nbt {
    override fun toString(): String = "${value}b"
}

data class ShortNbt(val value: Short) : Nbt {
    override fun toString(): String = "${value}s"
}

data class IntNbt(val value: Int) : Nbt {
    override fun toString(): String = "$value"
}

data class LongNbt(val value: Long) : Nbt {
    override fun toString(): String = "${value}l"
}

data class FloatNbt(val value: Float) : Nbt {
    override fun toString(): String = "${value}f"
}

data class DoubleNbt(val value: Double) : Nbt {
    override fun toString(): String = "${value}d"
}

data class ByteArrayNbt(val elements: List<Byte>) : Nbt {
    override fun toString(): String = elements.joinToString(",", "[B;", "]") { "${it}b" }
}

data class StringNbt(val value: String) : Nbt {
    override fun toString(): String = "\"${value.replace("\"", "\\\"")}\""
}

data class ListNbt(val elements: List<Nbt>) : Nbt {
    override fun toString(): String = elements.joinToString(",", "[", "]")
}

data class CompoundNbt(val elements: Map<String, Nbt>) : Nbt {
    override fun toString(): String = elements.entries.joinToString(",", "{", "}") { (key, value) -> "$key:$value" }
}

data class IntArrayNbt(val elements: List<Int>) : Nbt {
    override fun toString(): String = elements.joinToString(",", "[I;", "]")
}

data class LongArrayNbt(val elements: List<Long>) : Nbt {
    override fun toString(): String = elements.joinToString(",", "[L;", "]") { "${it}l" }
}

class CompoundNbtBuilder {
    private val elements: MutableMap<String, Nbt> = mutableMapOf()
    operator fun String.invoke(nbt: Nbt) = elements.put(this, nbt)
    operator fun String.invoke(value: Byte) = elements.put(this, ByteNbt(value))
    operator fun String.invoke(value: Short) = elements.put(this, ShortNbt(value))
    operator fun String.invoke(value: Int) = elements.put(this, IntNbt(value))
    operator fun String.invoke(value: Long) = elements.put(this, LongNbt(value))
    operator fun String.invoke(value: Float) = elements.put(this, FloatNbt(value))
    operator fun String.invoke(value: Double) = elements.put(this, DoubleNbt(value))
    operator fun String.invoke(value: String) = elements.put(this, StringNbt(value))
    operator fun String.invoke(block: CompoundNbtBuilder.() -> Unit) = elements.put(this, CompoundNbtBuilder().apply(block).build())
    fun build(): CompoundNbt = CompoundNbt(elements)
}

fun compound(block: CompoundNbtBuilder.() -> Unit): CompoundNbt = CompoundNbtBuilder().apply(block).build()

class Storage internal constructor(val name: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Storage = this
    fun at(name: String): NbtPath = NbtPath(this.name, CompoundChildNode(name))
    fun at(vararg names: String): NbtPath = NbtPath(name, names.map(::CompoundChildNode))
    fun filterCompound(name: String, pattern: CompoundNbt): NbtPath = NbtPath(this.name, MatchObjectNode(name, pattern))
    fun filterCompound(name: String, block: CompoundNbtBuilder.() -> Unit): NbtPath = filterCompound(name, CompoundNbtBuilder().apply(block).build())
    fun filterCompound(pattern: CompoundNbt): NbtPath = NbtPath(name, MatchRootNode(pattern))
    fun filterCompound(block: CompoundNbtBuilder.() -> Unit): NbtPath = filterCompound(CompoundNbtBuilder().apply(block).build())

    override fun toString(): String = name
}

class StorageProvider internal constructor() {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Storage = Storage(resourceLocation(thisRef, property))
}

fun storage() = StorageProvider()

data class NbtPath(val storage: String, val nodes: List<NbtPathNode>) {
    constructor(name: String, vararg nodes: NbtPathNode) : this(name, nodes.toList())

    fun all(): NbtPath = NbtPath(storage, nodes + AllElementsNode)
    fun at(name: String): NbtPath = NbtPath(storage, nodes + CompoundChildNode(name))
    fun at(vararg names: String): NbtPath = NbtPath(storage, nodes + names.map(::CompoundChildNode))
    fun at(index: Int): NbtPath = NbtPath(storage, nodes + IndexedElementNode(index))
    fun at(vararg indexes: Int): NbtPath = NbtPath(storage, nodes + indexes.map(::IndexedElementNode))
    fun first(): NbtPath = at(0)
    fun last(): NbtPath = at(-1)
    fun filterList(pattern: CompoundNbt): NbtPath = NbtPath(storage, nodes + MatchElementNode(pattern))
    fun filterList(block: CompoundNbtBuilder.() -> Unit): NbtPath = filterList(CompoundNbtBuilder().apply(block).build())
    fun filterCompound(name: String, pattern: CompoundNbt): NbtPath = NbtPath(storage, nodes + MatchObjectNode(name, pattern))
    fun filterCompound(name: String, block: CompoundNbtBuilder.() -> Unit): NbtPath = filterCompound(name, CompoundNbtBuilder().apply(block).build())

    override fun toString(): String = "storage $storage ${nodes.joinToString(".")}"
}

sealed interface NbtPathNode

data object AllElementsNode : NbtPathNode {
    override fun toString(): String = "[]"
}

data class CompoundChildNode(val name: String) : NbtPathNode {
    override fun toString(): String = name
}

data class IndexedElementNode(val index: Int) : NbtPathNode {
    override fun toString(): String = "[$index]"
}

data class MatchElementNode(val pattern: CompoundNbt) : NbtPathNode {
    override fun toString(): String = "[$pattern]"
}

data class MatchObjectNode(val name: String, val pattern: CompoundNbt) : NbtPathNode {
    override fun toString(): String = "$name$pattern"
}

data class MatchRootNode(val pattern: CompoundNbt) : NbtPathNode {
    override fun toString(): String = "$pattern"
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
    operator fun plusAssign(value: Int): Unit = when {
        value >= 0 -> +"scoreboard players add $this _ $value"
        value == Int.MIN_VALUE -> useTemp { it `=` value; this += it }
        else -> run { this -= -value }
    }

    operator fun minusAssign(value: Int): Unit = when {
        value >= 0 -> +"scoreboard players remove $this _ $value"
        value == Int.MIN_VALUE -> useTemp { it `=` value; this -= it }
        else -> run { this += -value }
    }

    operator fun timesAssign(value: Int) = useTemp { it `=` value; this *= it }
    operator fun divAssign(value: Int) = useTemp { it `=` value; this /= it }
    operator fun remAssign(value: Int) = useTemp { it `=` value; this %= it }
    infix fun `min=`(value: Int) = useTemp { it `=` value; this `min=` it }
    infix fun `max=`(value: Int) = useTemp { it `=` value; this `max=` it }
    override fun toString(): String = "#$name"

    private fun useTemp(block: (Score) -> Unit) {
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
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Function = Function(resourceLocation(thisRef, property), block)
}

fun function(block: FunctionContext.() -> Unit): FunctionProvider = FunctionProvider(block)

fun FunctionContext.function(block: FunctionContext.() -> Unit): Function = Function("$name/${nextFunction++}", block)

class MetaFunctionProvider1<A1> internal constructor(private val block: FunctionContext.(A1) -> Unit) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): F = F(resourceLocation(thisRef, property))
    inner class F(private val name: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): F = this
        operator fun invoke(a1: A1): Function = Function("$name/$a1") { block(a1) }
    }
}

fun <A1> metaFunction(block: FunctionContext.(A1) -> Unit): MetaFunctionProvider1<A1> = MetaFunctionProvider1(block)

class MetaFunctionProvider2<A1, A2> internal constructor(private val block: FunctionContext.(A1, A2) -> Unit) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): F = F(resourceLocation(thisRef, property))
    inner class F(private val name: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): F = this
        operator fun invoke(a1: A1, a2: A2): Function = Function("$name/$a1/$a2") { block(a1, a2) }
    }
}

fun <A1, A2> metaFunction(block: FunctionContext.(A1, A2) -> Unit): MetaFunctionProvider2<A1, A2> = MetaFunctionProvider2(block)

private fun resourceLocation(thisRef: Any?, property: KProperty<*>): String = "${thisRef?.javaClass?.name?.let { "$it/" } ?: ""}${property.name}".snakecase()

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
