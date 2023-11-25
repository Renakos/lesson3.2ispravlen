import java.util.*
fun main(args: Array<String>) {
        val store = Store()
        val user = User("Erjan", "Kara-Balta").apply {
            balance += 1000
        }
        val scanner = Scanner(System.`in`)
        store.displayProducts()
        print("Введите ID товара, который вы хотите купить: ")
        val productId = scanner.nextInt()
        store.buy(productId, user)
        with(store) {
            printProductNames()
        }
        with(user) {
            println("Баланс пользователя после покупки: $balance рублей")
        }
    }
