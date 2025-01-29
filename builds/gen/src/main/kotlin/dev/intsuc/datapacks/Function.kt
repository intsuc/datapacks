package dev.intsuc.datapacks

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.*
import kotlin.reflect.KProperty

class Function private constructor(
    val name: String,
    private val block: Builder.() -> Unit,
) {
    init {
        functions.add(this)
    }

    private fun generate(output: PackOutputStream) {
        output.entry("data/minecraft/function/$name.mcfunction")
        Builder().apply(block).build(output::line)
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

        private val json: Json = Json {
            prettyPrint = true
        }

        private val functions: MutableList<Function> = mutableListOf()

        operator fun invoke(block: Builder.() -> Unit): Delegate = Delegate(block)

        @OptIn(ExperimentalSerializationApi::class)
        private fun PackOutputStream.metadata() {
            entry("pack.mcmeta")
            json.encodeToStream(buildJsonObject {
                putJsonObject("pack") {
                    put("description", "")
                    put("pack_format", DATA_PACK_FORMAT)
                }
            }, this)
            write('\n'.code)
        }

        @OptIn(ExperimentalSerializationApi::class)
        fun PackOutputStream.generateAll(@Suppress("unused") vararg exports: Function) {
            metadata()
            while (functions.isNotEmpty()) {
                functions.removeLast().generate(this)
            }
        }
    }
}
