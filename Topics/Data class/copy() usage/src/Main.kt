data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val (h1, l1, l2, w1) = Array<Int>(4) { readLine()!!.toInt() }

    val box1 = Box(h1, l1, w1)
    val box2 = box1.copy(length = l2)

    println(box1)
    println(box2)
}