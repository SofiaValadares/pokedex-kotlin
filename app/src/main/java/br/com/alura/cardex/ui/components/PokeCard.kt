package br.com.alura.cardex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.cardex.R
import br.com.alura.cardex.models.Pokemon
import br.com.alura.cardex.sampledata.kantoPokemonList
import br.com.alura.cardex.ui.theme.DarkBlue
import br.com.alura.cardex.ui.theme.White
import coil.compose.AsyncImage

@Composable
fun PokeCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    val cardSize = 100.dp
    Column(
        modifier = modifier
            .size(cardSize)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = DarkBlue,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = "#${pokemon.dexNumber}",
            color = White,
            fontSize = 9.sp
        )

        AsyncImage(
            model = pokemon.image,
            contentDescription = pokemon.name,
            modifier = Modifier.size(cardSize * 0.4f),
            placeholder = painterResource(id = R.drawable.error_image),
            error = painterResource(id = R.drawable.error_image)
        )

        Text(
            text = pokemon.name.uppercase(),
            color = White,
            fontSize = 12.sp
        )


    }
}

@Preview(showBackground = true)
@Composable
private fun PokeCardPreview() {
    PokeCard(
        pokemon = kantoPokemonList[0]
    )
}