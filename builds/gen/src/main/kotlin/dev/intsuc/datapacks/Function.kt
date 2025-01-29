package dev.intsuc.datapacks

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import kotlin.reflect.KProperty

class Function private constructor(
    val name: String,
    private val block: Builder.() -> Unit,
) {
    init {
        functions.add(this)
    }

    private fun generate(writer: PackWriter) {
        writer.entry("data/minecraft/function/$name.mcfunction")
        Builder().apply(block).build(writer::write)
    }

    inner class Builder internal constructor() {
        private val commands: MutableList<String> = mutableListOf()

        operator fun invoke() = +Command.function(name)

        operator fun Function.invoke() = +Command.function(name)

        fun say(message: String) = +Command.say(message)

        internal fun build(block: (String) -> Unit) = commands.forEach(block)

        private operator fun String.unaryPlus() = commands.add(this)
    }

    class Delegate internal constructor(private val block: Builder.() -> Unit) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Function {
            val name = "${thisRef?.javaClass?.name?.let { "$it/" } ?: ""}${property.name}".snakecase()
            return functions.getOrPut(name) { Function(name, block) }
        }

        companion object {
            private val functions: MutableMap<String, Function> = mutableMapOf()
        }
    }

    companion object {
        private const val DATA_PACK_FORMAT: Int = 64

        @OptIn(ExperimentalSerializationApi::class)
        private val json: Json = Json {
            prettyPrint = true
            prettyPrintIndent = "  "
        }

        private val functions: MutableList<Function> = mutableListOf()

        operator fun invoke(block: Builder.() -> Unit): Delegate = Delegate(block)

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
        fun PackWriter.generateAll(@Suppress("unused") vararg exports: Function) = use {
            metadata()
            while (functions.isNotEmpty()) {
                functions.removeLast().generate(this)
            }
        }
    }
}
