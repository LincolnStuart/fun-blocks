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
import me.lincolnstuart.funblocks.playground.components.TokenItem

class CornerRadiusScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TokenItem(
                        tokenDescription = "small",
                        tokenValue = "2 DP"
                    )
                    TokenItem(
                        tokenDescription = "medium",
                        tokenValue = "4 DP"
                    )
                    TokenItem(
                        tokenDescription = "large",
                        tokenValue = "6 DP"
                    )
                    TokenItem(
                        tokenDescription = "huge",
                        tokenValue = "8 DP"
                    )
                    TokenItem(
                        tokenDescription = "enormous",
                        tokenValue = "12 DP"
                    )
                    TokenItem(
                        tokenDescription = "full",
                        tokenValue = "100%"
                    )
                }
            }
        }
    }
}
