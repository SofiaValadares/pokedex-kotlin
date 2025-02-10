package br.com.alura.cardex.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.cardex.ui.theme.Gray
import br.com.alura.cardex.ui.theme.White

@Composable
fun SearchBar(
    searchText: String,
    onSearchChange: (String) -> Unit,
    placeHolder: String,
    modifier: Modifier = Modifier,
) {


    Row(
        modifier = modifier
            .border(width = 2.dp, color = White, shape = RoundedCornerShape(100))
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)

    ) {
        Icon(
            Icons.Default.Search,
            contentDescription = "Shearch Icon",
            tint = White,
        )

        Box {
            BasicTextField(
                value = searchText,
                onValueChange = { onSearchChange(it) },
                textStyle = TextStyle(color = White),
                maxLines = 1
            )
            if (searchText.isBlank() || searchText.isEmpty()) {
                Text(placeHolder, color = Gray)
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
private fun SearchBarPreview() {
    Column {
        var value by rememberSaveable { mutableStateOf("") }
        SearchBar(searchText = value, onSearchChange = { value = it }, placeHolder = "Pokemon")
    }
}