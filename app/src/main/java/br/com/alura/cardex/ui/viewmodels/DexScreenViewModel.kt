package br.com.alura.cardex.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.cardex.dao.PokemonDao
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.regionsDex
import br.com.alura.cardex.ui.states.DexScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DexScreenViewModel : ViewModel() {

    private val dao = PokemonDao()

    private val _uiState: MutableStateFlow<DexScreenUiState> = MutableStateFlow(
        DexScreenUiState()
    )

    val uiState get() = _uiState.asStateFlow()

    init {

        _uiState.update { currentState ->
            currentState.copy(onSearchChange = {
                _uiState.value = _uiState.value.copy(
                    searchText = it, searchedPokemons = searchedPokemons(it)
                )
            }

            )
        }

        viewModelScope.launch {
            dao.pokemons().collect {
                _uiState.value = _uiState.value.copy(
                    pokemonsDex = regionsDex,
                    searchedPokemons = searchedPokemons(_uiState.value.searchText)
                )
            }
        }
    }


    private fun searchByNameOrDexNumber(text: String) = { pokemon: Pokemon ->
        pokemon.name.contains(
            text, ignoreCase = true
        ) || text.equals(pokemon.dexNumber.toString())
    }

    private fun searchedPokemons(text: String): List<Pokemon> = if (text.isNotBlank()) {
        dao.pokemons().value.filter(searchByNameOrDexNumber(text))
    } else emptyList()
}