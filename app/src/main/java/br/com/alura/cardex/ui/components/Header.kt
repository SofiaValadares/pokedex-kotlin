package br.com.alura.cardex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.R
import br.com.alura.cardex.ui.theme.DarkBlue
import br.com.alura.cardex.ui.theme.White

@Composable
fun Header(title: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .background(DarkBlue)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = White
            )
            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier.height(30.dp),
                value = text, onValueChange = { newValue ->
                    text = newValue
                },
                shape = RoundedCornerShape(100),
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Shearch Icon", tint = White)
                },
                label = {
                    Text(text = "Pokemon", color = White)
                },
            )
            Image(
                painter = painterResource(id = R.drawable.acount_icon),
                contentDescription = "Acount Icon"
            )
        }


    }
}

@Preview(showBackground = true, backgroundColor = 0xFF4d0580, heightDp = 100)
@Composable
private fun HeaderPreview() {
    Header("CardDex")
}