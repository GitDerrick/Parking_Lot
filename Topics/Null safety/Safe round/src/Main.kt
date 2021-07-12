fun main() {
    val number = readLine()!!.toInt()
    println(round(number) ?: 0)
}

fun round(number: Int): Int? {
    return if (number >= 1000) null else number
}