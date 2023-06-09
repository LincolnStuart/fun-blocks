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
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.playground.components.TokenItem
import kotlin.math.roundToInt

class ContentSizeScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TokenItem(
                        tokenDescription = "none",
                        tokenValue = "${FunBlocksContentSize.none.value.roundToInt()} DP"
                    )
                    SmallTokens()
                    TokenItem(
                        tokenDescription = "medium",
                        tokenValue = "${FunBlocksContentSize.medium.value.roundToInt()} DP"
                    )
                    LargeTokens()
                    HugeTokens()
                }
            }
        }
    }

    @Composable
    private fun HugeTokens() {
        TokenItem(
            tokenDescription = "huge",
            tokenValue = "${FunBlocksContentSize.huge.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xHuge",
            tokenValue = "${FunBlocksContentSize.xHuge.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xxHuge",
            tokenValue = "${FunBlocksContentSize.xxHuge.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xxxHuge",
            tokenValue = "${FunBlocksContentSize.xxxHuge.value.roundToInt()} DP"
        )
    }

    @Composable
    private fun LargeTokens() {
        TokenItem(
            tokenDescription = "large",
            tokenValue = "${FunBlocksContentSize.large.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xLarge",
            tokenValue = "${FunBlocksContentSize.xLarge.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xxLarge",
            tokenValue = "${FunBlocksContentSize.xxLarge.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xxxLarge",
            tokenValue = "${FunBlocksContentSize.xxxLarge.value.roundToInt()} DP"
        )
    }

    @Composable
    private fun SmallTokens() {
        TokenItem(
            tokenDescription = "xxxSmall",
            tokenValue = "${FunBlocksContentSize.xxxSmall.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xxSmall",
            tokenValue = "${FunBlocksContentSize.xxSmall.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "xSmall",
            tokenValue = "${FunBlocksContentSize.xSmall.value.roundToInt()} DP"
        )
        TokenItem(
            tokenDescription = "small",
            tokenValue = "${FunBlocksContentSize.small.value.roundToInt()} DP"
        )
    }
}
