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
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.playground.components.TokenItem
import kotlin.math.roundToInt

class SpacingScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TokenItem(
                        tokenDescription = "none",
                        tokenValue = "${FunBlocksSpacing.none.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "micro",
                        tokenValue = "${FunBlocksSpacing.micro.value}dp"
                    )
                    TokenItem(
                        tokenDescription = "tiny",
                        tokenValue = "${FunBlocksSpacing.tiny.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "xxxSmall",
                        tokenValue = "${FunBlocksSpacing.xxxSmall.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "xxSmall",
                        tokenValue = "${FunBlocksSpacing.xxSmall.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "xSmall",
                        tokenValue = "${FunBlocksSpacing.xSmall.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "small",
                        tokenValue = "${FunBlocksSpacing.small.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "medium",
                        tokenValue = "${FunBlocksSpacing.medium.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "large",
                        tokenValue = "${FunBlocksSpacing.large.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "xLarge",
                        tokenValue = "${FunBlocksSpacing.xLarge.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "xxLarge",
                        tokenValue = "${FunBlocksSpacing.xxLarge.value.roundToInt()}dp"
                    )
                    TokenItem(
                        tokenDescription = "xxxLarge",
                        tokenValue = "${FunBlocksSpacing.xxxLarge.value.roundToInt()}dp"
                    )
                }
            }
        }
    }
}
