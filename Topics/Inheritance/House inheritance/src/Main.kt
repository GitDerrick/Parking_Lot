fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house: House = when {
        rooms < 2 -> Cabin(rooms, price)
        rooms < 4 -> Bungalow(rooms, price)
        rooms < 5 -> Cottage(rooms, price)
        rooms < 8 -> Mansion(rooms, price)
        else -> Palace(rooms, price)
    }
    println(totalPrice(house))
}

fun totalPrice(house: House): Int = (house.price * house.coefficient).toInt()

open class House(val rooms: Int, var price: Int, val coefficient: Double) {
    init {
        this.price = when {
            price < 0 -> 0
            price > 1_000_000 -> 1_000_000
            else -> price
        }
    }
}

class Cabin(rooms: Int, price: Int) : House(rooms, price, 1.0)
class Bungalow(rooms: Int, price: Int) : House(rooms, price, 1.2)
class Cottage(rooms: Int, price: Int) : House(rooms, price, 1.25)
class Mansion(rooms: Int, price: Int) : House(rooms, price, 1.4)
class Palace(rooms: Int, price: Int) : House(rooms, price, 1.6)