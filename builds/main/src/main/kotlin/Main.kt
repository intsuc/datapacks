import dev.intsuc.datapacks.Function
import dev.intsuc.datapacks.Function.Companion.generateAll
import dev.intsuc.datapacks.PackOutputStream
import kotlin.io.path.Path

val helloWorld by Function {
    say("Hello, world!")
}

fun main(args: Array<String>) = PackOutputStream.ofFile(Path(args.first())).use {
    it.generateAll(
        helloWorld,
    )
}
