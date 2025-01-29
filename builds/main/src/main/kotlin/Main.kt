import dev.intsuc.datapacks.Function
import dev.intsuc.datapacks.Function.Companion.generateAll
import dev.intsuc.datapacks.PackWriter
import kotlin.io.path.Path

val helloWorld by Function {
    say("Hello, world!")
    this()
}

fun main(args: Array<String>) = PackWriter.ofPath(Path(args.first())).generateAll(
    helloWorld,
)
