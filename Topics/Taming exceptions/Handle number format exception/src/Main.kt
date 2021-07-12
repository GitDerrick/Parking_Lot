fun parseCardNumber(cardNumber: String): Long {
    val cardNumberArray = cardNumber.split(" ").toTypedArray()
    for (section in cardNumberArray) {
        if (section.length != 4) throw Exception("Invalid card number")
    }
    if (cardNumberArray.size != 4) throw Exception("Invalid card number")
    var newCardNumber = ""
    for (i in cardNumberArray.indices) newCardNumber += cardNumberArray[i]
    return newCardNumber.toLong()
}