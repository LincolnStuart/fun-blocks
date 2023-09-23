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
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize
import me.lincolnstuart.funblocks.playground.components.TokenItem
import kotlin.math.roundToInt

class FontSizeScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                val scrollState = rememberScrollState()
                Column(Modifier.verticalScroll(scrollState)) {
                    TokenItem(
                        tokenDescription = "small",
                        tokenValue = "${FunBlocksFontSize.small.value.roundToInt()}sp"
                    )
                    TokenItem(
                        tokenDescription = "medium",
                        tokenValue = "${FunBlocksFontSize.medium.value.roundToInt()}sp"
                    )
                    TokenItem(
                        tokenDescription = "large",
                        tokenValue = "${FunBlocksFontSize.large.value.roundToInt()}sp"
                    )
                    TokenItem(
                        tokenDescription = "xLarge",
                        tokenValue = "${FunBlocksFontSize.xLarge.value.roundToInt()}sp"
                    )
                    TokenItem(
                        tokenDescription = "xxLarge",
                        tokenValue = "${FunBlocksFontSize.xxLarge.value.roundToInt()}sp"
                    )
                    TokenItem(
                        tokenDescription = "xxxLarge",
                        tokenValue = "${FunBlocksFontSize.xxxLarge.value.roundToInt()}sp"
                    )
                    TokenItem(
                        tokenDescription = "huge",
                        tokenValue = "${FunBlocksFontSize.xxxLarge.value.roundToInt()}sp"
                    )
                }
            }
        }
    }
}
