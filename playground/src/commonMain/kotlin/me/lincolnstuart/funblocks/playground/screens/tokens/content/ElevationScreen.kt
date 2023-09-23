package me.lincolnstuart.funblocks.playground.screens.tokens.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.elevation.FunBlocksElevationLevel
import me.lincolnstuart.funblocks.playground.components.TokenItem
import kotlin.math.roundToInt

class ElevationScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TokenItem(
                        tokenDescription = "low",
                        tokenValue = "${FunBlocksElevationLevel.low.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "medium",
                        tokenValue = "${FunBlocksElevationLevel.medium.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "high",
                        tokenValue = "${FunBlocksElevationLevel.high.value.roundToInt()}dp"
                    )
                }
            }
        }
    }
}
