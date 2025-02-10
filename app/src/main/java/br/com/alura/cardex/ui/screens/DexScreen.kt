package br.com.alura.cardex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.allPokemonList
import br.com.alura.cardex.sampledata.regionsDex
import br.com.alura.cardex.ui.components.Header
import br.com.alura.cardex.ui.components.PokeCardsSection
import br.com.alura.cardex.ui.components.SearchBar
import br.com.alura.cardex.ui.theme.BackgroundColor

@Composable
fun DexScreen(dex: Map<String, List<Pokemon>>) {
    Column (modifier = Modifier.background(color = BackgroundColor)) {
        var value by remember { mutableStateOf("") }
        Header(
            title = "CardDex",
            searchBar = {
                SearchBar(
                    searchText = value,
                    onSearchChange = { value = it },
                    placeHolder = "Pokemon",
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .height(40.dp)
                )
            },
            modifier = Modifier.padding(bottom = 10.dp))

        val searchPokemonFilter = remember (value) {
            allPokemonList.filter { pokemon ->
                pokemon.name.contains(
                    value,
                    ignoreCase = true
                ) || value.equals(pokemon.dexNumber.toString())
            }
        }

        if (value.isEmpty() || value.isBlank()) {
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
                pokemons = searchPokemonFilter,
                modifier = Modifier.fillMaxSize()
            )
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun DexScreenPreview() {
    DexScreen(dex = regionsDex)
}
