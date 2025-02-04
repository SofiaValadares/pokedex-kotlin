package br.com.alura.cardex.models

class Pokemon(
    name: String,
    dexNumber: Int,
    val image: String? = null
) {
    var name: String = name.uppercase()
        private set

    var dexNumber: Int = dexNumber
        private set
}
