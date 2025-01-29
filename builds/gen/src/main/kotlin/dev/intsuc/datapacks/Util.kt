package dev.intsuc.datapacks

fun String.snakecase(): String {
    val builder = StringBuilder()
    for (i in indices) {
        val c = this[i]
        if (c.isUpperCase() && i > 0) {
            builder.append('_')
        }
        builder.append(c.lowercase())
    }
    return builder.toString()
}
