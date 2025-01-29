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
        Builder().apply(block).build { command ->
            output.line(command)
        }
    }

    class Builder internal constructor() {
        private val commands: MutableList<String> = mutableListOf()

        operator fun Function.invoke() = commands.add("function $name")

        fun say(message: String) = commands.add("say $message")

        internal fun build(block: (String) -> Unit) {
            for (command in commands) {
                block(command)
            }
        }
    }

    class Delegate internal constructor(private val block: Builder.() -> Unit) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Function {
            val name = "${thisRef?.javaClass?.name?.snakecase()?.let { "$it/" } ?: ""}${property.name.snakecase()}"
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
