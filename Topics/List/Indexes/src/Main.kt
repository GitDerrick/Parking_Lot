fun solution(products: List<String>, product: String) {
    for ((i, item) in products.withIndex()) {
        if (item == product) print("$i ")
    }
}