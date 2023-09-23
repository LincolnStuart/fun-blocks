package me.lincolnstuart.funblocks.playground.screens.tokens.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.playground.components.TokenItem
import kotlin.math.roundToInt

class BorderWidthScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TokenItem(
                        tokenDescription = "none",
                        tokenValue = "${FunBlocksBorderWidth.none.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "tiny",
                        tokenValue = "${FunBlocksBorderWidth.tiny.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "regular",
                        tokenValue = "${FunBlocksBorderWidth.regular.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "large",
                        tokenValue = "${FunBlocksBorderWidth.large.value.roundToInt()}dp"
                    )
                }
            }
        }
    }
}
