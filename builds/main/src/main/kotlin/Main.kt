import dev.intsuc.datapacks.*
import dev.intsuc.datapacks.Function
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
    !"comment"

    this()
    f()
}

val f: Function by function {
    helloWorld()
    CompileTimeFunction("foo")()
    CompileTimeFunction("bar")()
    CompileTimeFunction2("baz", 3)()
}

val CompileTimeFunction by metaFunction<String> { message ->
    say(message)
}

val CompileTimeFunction2 by metaFunction<String, Int> { message, count ->
    say(message.repeat(count))
}

fun main(args: Array<String>) = PackWriter.ofPath(Path(args.first())).write()
