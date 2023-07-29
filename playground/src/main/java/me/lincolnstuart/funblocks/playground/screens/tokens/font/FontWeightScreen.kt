package me.lincolnstuart.funblocks.playground.screens.tokens.font

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontWeight
import me.lincolnstuart.funblocks.playground.components.TokenItem

class FontWeightScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                val scrollState = rememberScrollState()
                Column(Modifier.verticalScroll(scrollState)) {
                    TokenItem(
                        tokenDescription = "light",
                        tokenValue = FunBlocksFontWeight.light.weight.toString()
                    )
                    TokenItem(
                        tokenDescription = "regular",
                        tokenValue = FunBlocksFontWeight.regular.weight.toString()
                    )
                    TokenItem(
                        tokenDescription = "semiBold",
                        tokenValue = FunBlocksFontWeight.semiBold.weight.toString()
                    )
                    TokenItem(
                        tokenDescription = "bold",
                        tokenValue = FunBlocksFontWeight.bold.weight.toString()
                    )
                }
            }
        }
    }
}
