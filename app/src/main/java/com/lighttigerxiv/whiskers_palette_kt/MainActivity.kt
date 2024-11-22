package com.lighttigerxiv.whiskers_palette_kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lighttigerxiv.whiskers_palette_kt.ui.theme.WhiskersPaletteKtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val vm: MainViewModel = viewModel()
            val palette = vm.state.collectAsState().value.palette

            WhiskersPaletteKtTheme(palette = palette) {
                Column(
                    modifier = Modifier
                        .background(getComposedColor(palette.neutralTwo))
                        .systemBarsPadding()
                ) {
                    MainScreen(vm)
                }
            }
        }
    }
}