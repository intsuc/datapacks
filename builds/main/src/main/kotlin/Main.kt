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
    b += a
    b -= a
    b *= a
    b /= a
    b %= a
    b `min=` a
    b `max=` a
    b swap a

    b `=` 0
    b += 1
    b -= 2
    b *= 3
    b /= 4
    b %= 5
    b `min=` 6
    b `max=` 7

    val c by score(30)
    val d by score(40)
    b = score { a * b + c * d }
    !"comment 1"
    b = score { a + b * c - d / a % b min c max d }
    !"comment 2"
    b = score { a + score { b + score { c + d } + a } + b }

    this()
    f()
}

val f: Function by function {
    helloWorld()
}

fun main(args: Array<String>) = PackWriter.ofPath(Path(args.first())).write()
