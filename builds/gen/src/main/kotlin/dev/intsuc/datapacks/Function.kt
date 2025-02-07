@file:Suppress("FunctionName")

package dev.intsuc.datapacks

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import kotlin.reflect.KProperty

class Function internal constructor(
    val name: String,
    private val block: FunctionBuilder.() -> Unit,
) {
    init {
        entries.add(this)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Function = this

    internal fun generate(writer: PackWriter) {
        writer.entry("data/minecraft/function/$name.mcfunction")
        FunctionBuilder(name).apply(block).build(writer::write)
    }

    companion object {
        internal val entries: MutableList<Function> = mutableListOf()
    }
}

class FunctionProvider internal constructor(private val block: FunctionBuilder.() -> Unit) {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Function {
        val name = "${thisRef?.javaClass?.name?.let { "$it/" } ?: ""}${property.name}".snakecase()
        return Function(name, block)
    }
}

class FunctionBuilder internal constructor(private val name: String) {
    private val commands: MutableList<String> = mutableListOf()
    private var nextTemp: Int = 0

    operator fun String.not() = +"# $this"

    operator fun invoke() = +"function $name"

    operator fun Function.invoke() = +"function $name"

    fun say(message: String) = +"say $message"

    fun score(value: Int) = ScoreProvider(value)

    fun score(block: ScoreBuilder.() -> Unit): Score = ScoreBuilder(++nextTemp).apply(block).build()

    inner class Score internal constructor(val name: String) {
        val isTemp: Boolean by lazy { name.toIntOrNull() != null }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): Score = this

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Score) = +"scoreboard players operation $this _ = $value _"

        infix fun `=`(source: Score) = if (this !== source) run { +"scoreboard players set $this _ = $source _" } else Unit

        operator fun plusAssign(source: Score) = +"scoreboard players operation $this _ += $source _"

        operator fun minusAssign(source: Score) = +"scoreboard players operation $this _ -= $source _"

        operator fun timesAssign(source: Score) = +"scoreboard players operation $this _ *= $source _"

        operator fun divAssign(source: Score) = +"scoreboard players operation $this _ /= $source _"

        operator fun remAssign(source: Score) = +"scoreboard players operation $this _ %= $source _"

        infix fun `min=`(source: Score) = +"scoreboard players operation $this _ < $source _"

        infix fun `max=`(source: Score) = +"scoreboard players operation $this _ > $source _"

        infix fun swap(source: Score) = +"scoreboard players operation $this _ >< $source _"

        infix fun `=`(value: Int) = run { +"scoreboard players set $this _ $value" }

        operator fun plusAssign(value: Int) = +"scoreboard players add $this _ $value"

        operator fun minusAssign(value: Int) = +"scoreboard players remove $this _ $value"

        operator fun timesAssign(value: Int) = useTemp { it `=` value; this *= it }

        operator fun divAssign(value: Int) = useTemp { it `=` value; this /= it }

        operator fun remAssign(value: Int) = useTemp { it `=` value; this %= it }

        infix fun `min=`(value: Int) = useTemp { it `=` value; this `min=` it }

        infix fun `max=`(value: Int) = useTemp { it `=` value; this `max=` it }

        private inline fun useTemp(block: (Score) -> Unit) = block(Score((++nextTemp).toString())).also { nextTemp -= 1 }

        override fun toString(): String = "#$name"
    }

    inner class ScoreBuilder internal constructor(private val initialTemp: Int) {
        private lateinit var lastTemp: Score

        operator fun Score.plus(right: Score): Score = newTemp(this, right) { it `=` this; it += right }

        operator fun Score.minus(right: Score): Score = newTemp(this, right) { it `=` this; it -= right }

        operator fun Score.times(right: Score): Score = newTemp(this, right) { it `=` this; it *= right }

        operator fun Score.div(right: Score): Score = newTemp(this, right) { it `=` this; it /= right }

        operator fun Score.rem(right: Score): Score = newTemp(this, right) { it `=` this; it %= right }

        infix fun Score.min(right: Score): Score = newTemp(this, right) { it `=` this; it `min=` right }

        infix fun Score.max(right: Score): Score = newTemp(this, right) { it `=` this; it `max=` right }

        private inline fun newTemp(left: Score, right: Score, block: (Score) -> Unit): Score = when {
            left.isTemp && right.isTemp -> left.also(block)
            else -> Score((++nextTemp).toString()).also(block)
        }.also { lastTemp = it }

        fun build(): Score {
            nextTemp = initialTemp - 1
            return lastTemp
        }
    }

    inner class ScoreProvider internal constructor(private val value: Int) {
        operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Score = Score(property.name).also {
            +"scoreboard players set $it _ $value"
        }
    }

    internal fun build(block: (String) -> Unit) = commands.forEach(block)

    private operator fun String.unaryPlus(): Unit = run { commands.add(this) }
}

private const val DATA_PACK_FORMAT: Int = 64

@OptIn(ExperimentalSerializationApi::class)
private val json: Json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
}

@OptIn(ExperimentalSerializationApi::class)
private fun PackWriter.metadata() {
    entry("pack.mcmeta")
    write(json.encodeToString(buildJsonObject {
        putJsonObject("pack") {
            put("description", "")
            put("pack_format", DATA_PACK_FORMAT)
        }
    }))
}

@OptIn(ExperimentalSerializationApi::class)
fun PackWriter.write() = use {
    metadata()
    while (Function.entries.isNotEmpty()) {
        Function.entries.removeLast().generate(this)
    }
}

fun function(block: FunctionBuilder.() -> Unit): FunctionProvider = FunctionProvider(block)
