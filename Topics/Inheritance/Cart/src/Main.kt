fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()

    val product = when (productType) {
        "headphones" -> HeadPhones(price)
        "smartphone" -> SmartPhone(price)
        "tv" -> TV(price)
        else -> Laptop(price)
    }
    println(totalPrice(product))
}

fun totalPrice(product: Product) = product.totalPrice()

open class Product(val price: Int, val tax: Int = 0) {
    fun totalPrice() = price + price * tax / 100
}
class HeadPhones(price: Int) : Product(price, 11)
class SmartPhone(price: Int) : Product(price, 15)
class TV(price: Int) : Product(price, 17)
class Laptop(price: Int) : Product(price, 19)