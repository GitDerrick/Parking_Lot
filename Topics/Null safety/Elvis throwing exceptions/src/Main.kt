fun main() {
    println("Elvis says: " + (readLine() ?: throw IllegalStateException()))
}