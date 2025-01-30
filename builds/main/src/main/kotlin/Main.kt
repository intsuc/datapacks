import dev.intsuc.datapacks.Function
import dev.intsuc.datapacks.PackWriter
import dev.intsuc.datapacks.function
import dev.intsuc.datapacks.write
import kotlin.io.path.Path

val helloWorld by function {
    say("Hello, world!")
    val a by score(10)
    var b by score(20)
    b = a
    b += 1
    b -= 2
    this()
    f()
}

val f: Function by function {
    helloWorld()
}

fun main(args: Array<String>) = PackWriter.ofPath(Path(args.first())).write()
