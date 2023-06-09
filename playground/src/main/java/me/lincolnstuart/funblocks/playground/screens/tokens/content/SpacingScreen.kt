package me.lincolnstuart.funblocks.playground.screens.tokens.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.surface.Surface
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
                        tokenValue = "${FunBlocksSpacing.none.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "micro",
                        tokenValue = "${FunBlocksSpacing.micro.value} DP"
                    )
                    TokenItem(
                        tokenDescription = "tiny",
                        tokenValue = "${FunBlocksSpacing.tiny.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "xxxSmall",
                        tokenValue = "${FunBlocksSpacing.xxxSmall.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "xxSmall",
                        tokenValue = "${FunBlocksSpacing.xxSmall.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "xSmall",
                        tokenValue = "${FunBlocksSpacing.xSmall.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "small",
                        tokenValue = "${FunBlocksSpacing.small.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "medium",
                        tokenValue = "${FunBlocksSpacing.medium.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "large",
                        tokenValue = "${FunBlocksSpacing.large.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "xLarge",
                        tokenValue = "${FunBlocksSpacing.xLarge.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "xxLarge",
                        tokenValue = "${FunBlocksSpacing.xxLarge.value.roundToInt()} DP"
                    )
                    TokenItem(
                        tokenDescription = "xxxLarge",
                        tokenValue = "${FunBlocksSpacing.xxxLarge.value.roundToInt()} DP"
                    )
                }
            }
        }
    }
}
