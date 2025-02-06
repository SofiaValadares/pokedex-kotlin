package br.com.alura.cardex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.alura.cardex.sampledata.regionsDex
import br.com.alura.cardex.ui.screens.DexScreen
import br.com.alura.cardex.ui.theme.BackgroundColor
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
        Surface (
            color = BackgroundColor
        ) {
            DexScreen(dex = regionsDex)
        }
    }
}



