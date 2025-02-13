package br.com.alura.cardex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.ui.components.Header
import br.com.alura.cardex.ui.components.PokeCardsSection
import br.com.alura.cardex.ui.components.SearchBar
import br.com.alura.cardex.ui.states.DexScreenUiState
import br.com.alura.cardex.ui.theme.BackgroundColor
import br.com.alura.cardex.ui.viewmodels.DexScreenViewModel


@Composable
fun DexScreen(
    viewModel: DexScreenViewModel
) {
    val state by viewModel.uiState.collectAsState()
    DexScreen(state = state)
}

@Composable
fun DexScreen(
    state: DexScreenUiState = DexScreenUiState(),
) {
    val dex = state.pokemonsDex
    val searchedPokemonsFilter = state.searchedPokemons

    Column(modifier = Modifier.background(color = BackgroundColor)) {

        Header(
            title = "CardDex",
            searchBar = {
                SearchBar(
                    text = state.searchText,
                    onSearchChange = { state.onSearchChange(it) },
                    placeHolder = "Pokemon"
                )
            },
            modifier = Modifier.padding(bottom = 10.dp))


        if (state.isShowSections()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                items(
                    items = dex.entries.toList(),
                    key = { it.key }
                ) { regionEntry ->
                    PokeCardsSection(
                        title = regionEntry.key,
                        pokemons = regionEntry.value
                    )
                }
            }
        } else {
            PokeCardsSection(
                pokemons = searchedPokemonsFilter,
                modifier = Modifier.fillMaxSize()
            )
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun DexScreenPreview() {
    DexScreen()
}
