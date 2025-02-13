package br.com.alura.cardex.ui.states

import br.com.alura.cardex.models.Pokemon

data class DexScreenUiState(
    val pokemonsDex: Map<String, List<Pokemon>> = emptyMap(),
    val searchedPokemons: List<Pokemon> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
) {

    fun isShowSections(): Boolean {
        return searchText.isBlank() || searchText.isEmpty()

    }

}
