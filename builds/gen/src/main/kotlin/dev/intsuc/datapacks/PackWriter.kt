package dev.intsuc.datapacks

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import java.io.Closeable
import java.io.Writer
import java.nio.file.Path
import java.util.zip.ZipOutputStream
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.createParentDirectories
import kotlin.io.path.deleteRecursively
import kotlin.io.path.outputStream

interface PackWriter : Closeable {
    fun entry(name: String)

    fun write(text: String)

    fun write() = use {
        metadata()
        while (Function.entries.isNotEmpty()) {
            val function = Function.entries.removeLast()
            entry("data/minecraft/function/${function.name}.mcfunction")
            FunctionContext(function.name).apply(function.block).build(this::write)
        }
    }

    private fun PackWriter.metadata() {
        entry("pack.mcmeta")
        write(json.encodeToString(buildJsonObject {
            putJsonObject("pack") {
                put("description", "")
                put("pack_format", DATA_PACK_FORMAT)
            }
        }))
    }

    companion object {
        private const val DATA_PACK_FORMAT: Int = 66

        @OptIn(ExperimentalSerializationApi::class)
        private val json: Json = Json {
            prettyPrint = true
            prettyPrintIndent = "  "
        }

        fun ofFile(path: Path): PackWriter = object : PackWriter {
            private val output = ZipOutputStream(path.outputStream().buffered())

            override fun entry(name: String) {
                output.putNextEntry(java.util.zip.ZipEntry(name))
            }

            override fun write(text: String) {
                output.write(text.encodeToByteArray())
                output.write('\n'.code)
            }

            override fun close() {
                output.close()
            }
        }

        @OptIn(ExperimentalPathApi::class)
        fun ofPath(root: Path): PackWriter = object : PackWriter {
            init {
                root.deleteRecursively()
            }

            private var current: Writer? = null

            override fun entry(name: String) {
                current?.close()
                current = root.resolve(name).createParentDirectories().outputStream().bufferedWriter()
            }

            override fun write(text: String) {
                val current = current!!
                current.write(text)
                current.write('\n'.code)
            }

            override fun close() {
                current?.close()
            }
        }
    }
}
