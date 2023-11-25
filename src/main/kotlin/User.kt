data class User(
    val name: String,
    val address: String) {
    var balance: Int = 0
        set(value) {
            if (value in 0..100000) {
                field = value
            } else {
                throw IllegalArgumentException("За раз можно пополнить баланс только на сумму не выше 100000")
            }
        }
        get() = field

}