package br.com.alura.cardex.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.cardex.sampledata.pokemonList
import br.com.alura.cardex.ui.components.PokeCardsSection

@Composable
fun DexScreen() {
    PokeCardsSection(pokemons = pokemonList)
}

@Preview(showSystemUi = true)
@Composable
private fun DexScreenPreview() {
    DexScreen()
}