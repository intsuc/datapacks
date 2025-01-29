package dev.intsuc.datapacks

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

    companion object {
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
