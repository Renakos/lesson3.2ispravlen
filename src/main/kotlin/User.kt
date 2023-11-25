data class User(val name: String, val address: String, var balance: Int = 0) {
    init {
        if (balance !in 0..100000) {
            throw IllegalArgumentException("За раз можно пополнить баланс только на сумму не выше 100000")
        }
    }

    var customBalance: Int
        set(value) {
            if (value in 0..100000) {
                balance = value
            } else {
                throw IllegalArgumentException("За раз можно пополнить баланс только на сумму не выше 100000")
            }
        }
        get() = balance
}