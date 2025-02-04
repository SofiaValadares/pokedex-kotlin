package br.com.alura.cardex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.cardex.R
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.pokemonList
import br.com.alura.cardex.ui.theme.DarkBlue
import br.com.alura.cardex.ui.theme.White
import coil.compose.AsyncImage


@Composable
fun PokeCard(pokemon: Pokemon) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 4.dp
    ) {
        val size = 100
        Column(
            modifier = Modifier
                .height(size.dp)
                .width(size.dp)
                .background(DarkBlue)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#${pokemon.dexNumber}",
                color = White,
                fontSize = 9.sp
            )
            AsyncImage(
                model = pokemon.image,
                contentDescription = "PokemonImage",
                modifier = Modifier
                    .size((size * 0.5).dp),
                placeholder = painterResource(id = R.drawable.error_image),
                error = painterResource(id = R.drawable.error_image)
            )
            Text(
                text = pokemon.name,
                color = White,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PokeCardPreview() {
    PokeCard(
        pokemon = pokemonList[0]
    )
}