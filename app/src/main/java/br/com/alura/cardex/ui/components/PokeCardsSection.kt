package br.com.alura.cardex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.pokemonList

@Composable
fun PokeCardsSection(pokemons: List<Pokemon>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 5.dp)
    ) {
        items(pokemons) { p->
            PokeCard(p)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PokeCardsSectionPreview() {
    PokeCardsSection(pokemonList)
}

