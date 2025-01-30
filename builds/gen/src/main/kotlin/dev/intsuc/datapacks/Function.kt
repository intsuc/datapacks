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

    operator fun invoke() = +"function $name"

    operator fun Function.invoke() = +"function $name"

    fun say(message: String) = +"say $message"

    fun score(value: Int) = ScoreProvider(value)

    inner class Score internal constructor(val name: String) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Score = this

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Score) = +"scoreboard players operation #${property.name} _ = #${value.name} _"

        operator fun plusAssign(value: Int) = +"scoreboard players add #$name _ $value"

        operator fun minusAssign(value: Int) = +"scoreboard players remove #$name _ $value"
    }

    inner class ScoreProvider internal constructor(private val value: Int) {
        operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): Score {
            +"scoreboard players set #${property.name} _ $value"
            return Score(property.name)
        }
    }

    internal fun build(block: (String) -> Unit) = commands.forEach(block)

    private operator fun String.unaryPlus() {
        commands.add(this)
    }
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
