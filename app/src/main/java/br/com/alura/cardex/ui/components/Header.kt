package br.com.alura.cardex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.R
import br.com.alura.cardex.ui.theme.DarkBlue
import br.com.alura.cardex.ui.theme.White

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier,
    searchBar:@Composable () -> Unit = {},
    buttonProfile: () -> Unit = {},
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Row(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = White
            )

            OutlinedButton(onClick = { buttonProfile() }) {
                Image(
                    painter = painterResource(id = R.drawable.acount_icon),
                    contentDescription = "Account Icon"
                )
            }

        }

        searchBar()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4d0580, heightDp = 100)
@Composable
private fun HeaderPreview() {
    Header(
        title = "CardDex",
        searchBar = {
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .height(30.dp)
            )
                    },
        buttonProfile = {},
        )
}