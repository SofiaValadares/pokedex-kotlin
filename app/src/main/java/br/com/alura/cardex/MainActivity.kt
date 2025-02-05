package br.com.alura.cardex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.alura.cardex.sampledata.regionsDex
import br.com.alura.cardex.ui.screens.DexScreen
import br.com.alura.cardex.ui.theme.CardexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    CardexTheme {
        Surface {
            DexScreen(dex = regionsDex)
        }
    }
}



