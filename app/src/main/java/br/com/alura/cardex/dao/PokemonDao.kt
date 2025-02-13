package br.com.alura.cardex.dao

import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.allPokemonList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonDao {

    companion object {
        private val pokemons = MutableStateFlow<List<Pokemon>>(allPokemonList)
    }

    fun pokemons(): StateFlow<List<Pokemon>> = pokemons.asStateFlow()
}