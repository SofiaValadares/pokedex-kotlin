package br.com.alura.cardex.models

class Pokemon(
    name: String,
    val dexNumber: Int,
    val image: String? = null
) {
    val name: String = name.uppercase()
}
