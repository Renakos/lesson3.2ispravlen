class Store: Buyable  {
    val products = mutableMapOf<Int, Product>()

    init {
        addProduct(1, Product("Товар 1", 100))
        addProduct(2, Product("Товар 2", 150))
        addProduct(3, Product("Товар 3", 200))
    }

    fun addProduct(id: Int, product: Product) {
        products[id] = product
    }

    override fun buy(productId: Int, buyer: User) {
        when (productId) {
            1, 2, 3 -> {
                val product = products[productId]
                product?.apply {
                    val amount = this.price
                    println("Покупатель: ${buyer.name}")
                    println("Товар: ${this.name}")
                    println("Стоимость товара: $amount рублей")
                    println("Адрес доставки: ${buyer.address}")

                    buyer.balance -= amount
                    println("Списано с баланса: $amount рублей")

                    buyer.also {
                        println("Оставшийся баланс: ${it.balance} рублей")
                    }
                }
            }
            else -> println("Вы ввели неверный id товара")
        }
    }
    fun printProductNames() {
        println("Названия товаров в магазине:")
        products.values.forEach { product ->
            println(product.name)
        }
    }
    fun displayProducts() {
        println("Товары в магазине:")
        for ((id, product) in products) {
            println("ID: $id, Название: ${product.name}, Цена: ${product.price}")
        }
    }
}