package br.com.alura.cardex.models

data class Pokemon(
    val name: String,
    val dexNumber: Int,
    val image: String? = null
) {
}
