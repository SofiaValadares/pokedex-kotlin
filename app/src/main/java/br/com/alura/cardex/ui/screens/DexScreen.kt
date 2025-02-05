package br.com.alura.cardex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.kantoPokemonList
import br.com.alura.cardex.sampledata.regionsDex
import br.com.alura.cardex.ui.components.PokeCardsSection

@Composable
fun DexScreen(dex: Map<String, List<Pokemon>>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 10.dp)
    ) {
        // Converte o map para uma lista de entries para iterar de forma mais performática
        items(
            items = dex.entries.toList(),
            key = { it.key } // Define uma chave estável para cada região
        ) { regionEntry ->
            PokeCardsSection(
                title = regionEntry.key,
                pokemons = regionEntry.value
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DexScreenPreview() {
    DexScreen(dex = regionsDex)
}
