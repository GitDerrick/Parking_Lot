//fun main() {
//    val (a, operator , b) = readLine()!!.split(" ")
//    when (operator) {
//        "-" -> subtractTwoNumbers(a.toLong(), b.toLong())
//        "+" -> sumTwoNumbers(a.toLong(), b.toLong())
//        "/" -> divideTwoNumbers(a.toLong(), b.toLong())
//        "*" -> multiplyTwoNumbers(a.toLong(), b.toLong())
//    }
//}

fun subtractTwoNumbers(a: Long, b: Long) = println(a - b)

fun sumTwoNumbers(a: Long, b: Long) = println(a + b)

fun divideTwoNumbers(a: Long, b: Long) =
    if (b == 0L) println("Division by 0!") else println(a / b)

fun multiplyTwoNumbers(a: Long, b: Long) = println(a * b)