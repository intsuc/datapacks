import dev.intsuc.datapacks.*
import dev.intsuc.datapacks.Function
import dev.intsuc.datapacks.storage
import kotlin.io.path.Path

val globalStorage by storage()

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

    b += Int.MAX_VALUE
    b += Int.MIN_VALUE
    b += -1

    b -= Int.MAX_VALUE
    b -= Int.MIN_VALUE
    b -= -1

    !"comment"

    val c = compound {
        "a"(1)
        "b" {
            "c"(2)
        }
    }

    globalStorage.merge(c)
    globalStorage.merge { }
    globalStorage
        .filterCompound {}
        .all()
        .at("a")
        .at(0)
        .at(-1)
        .filterList {}
        .filterCompound("b") {}
        .remove()

    val localStorage by storage()
    val path = localStorage.at("a", "b").at(1, 2).first().last()
    path.get()
    path.get(2.0)
    path.append(localStorage.at("a"))
    path.append(localStorage.at("a"), true)
    path.append(c)
    path.append { "a"(1) }
    path.insert(2) { "a"(1) }

    this()
    f()
}

val f: Function by function {
    helloWorld()
    CompileTimeFunction("foo")()
    CompileTimeFunction("bar")()
    CompileTimeFunction2("baz", 2)()
    HigherOrderFunction(CompileTimeFunction("a"))()
    HigherOrderFunction(CompileTimeFunction("b"))()
    HigherOrderFunction(function { say("c") })()
    HigherOrderFunction(function { say("d") })()
}

val CompileTimeFunction by metaFunction<String> { message ->
    say(message)
}

val CompileTimeFunction2 by metaFunction<String, Int> { message, count ->
    say(message.repeat(count))
}

val HigherOrderFunction by metaFunction<Function> { f ->
    say("begin")
    f()
    say("end")
}

fun main(args: Array<String>) = PackWriter.ofPath(Path(args.first())).write()
