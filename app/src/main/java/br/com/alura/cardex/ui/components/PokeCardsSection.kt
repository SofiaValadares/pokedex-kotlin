package br.com.alura.cardex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.kantoPokemonList
import br.com.alura.cardex.ui.theme.White
import kotlin.math.ceil


@Composable
fun PokeCardsSection(pokemons: List<Pokemon>, title: String? = null, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        val rows = ceil(pokemons.size / 3.0).toInt()

        if (title != null) {
            Text(
                text = title,
                Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                color = White
            )
        }

        LazyVerticalGrid(
            modifier = Modifier.height((110 * rows).dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 5.dp)
        ) {
            items(pokemons) { p ->
                PokeCard(p)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PokeCardsSectionPreview() {
    PokeCardsSection(title = "KANTO", pokemons = kantoPokemonList)
}

