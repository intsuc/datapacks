package dev.intsuc.datapacks

import java.io.FilterOutputStream
import java.io.OutputStream
import java.nio.file.Path
import java.util.zip.ZipOutputStream
import kotlin.io.path.outputStream

abstract class PackOutputStream(output: OutputStream) : FilterOutputStream(output) {
    abstract fun entry(name: String)

    abstract fun line(text: String)

    companion object {
        fun ofFile(path: Path): PackOutputStream {
            val output = ZipOutputStream(path.outputStream().buffered())
            return object : PackOutputStream(output) {
                override fun entry(name: String) {
                    output.putNextEntry(java.util.zip.ZipEntry(name))
                }

                override fun line(text: String) {
                    output.write(text.encodeToByteArray())
                    output.write('\n'.code)
                }
            }
        }
    }
}
