package br.com.alura.cardex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.alura.cardex.sampledata.allPokemonList
import br.com.alura.cardex.ui.screens.DexScreen
import br.com.alura.cardex.ui.theme.BackgroundColor
import br.com.alura.cardex.ui.theme.CardexTheme
import br.com.alura.cardex.ui.viewmodels.DexScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App {
                val viewModel by viewModels<DexScreenViewModel> ()
                DexScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit = {},) {
    CardexTheme {
        Surface (
            color = BackgroundColor
        ) {
           content()
        }
    }
}



