package me.lincolnstuart.funblocks.sample.screens.misc.progress

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import me.lincolnstuart.funblocks.essentials.misc.progress.ProgressBar
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.sample.components.Playground

class ProgressBarScreen : Screen {

    @Composable
    override fun Content() {
        var percent by remember {
            mutableStateOf(33.3f)
        }
        LaunchedEffect(Unit) {
            delay(2000)
            percent = 75f
            delay(2000)
            percent = 98f
            delay(2000)
            percent = 100f
        }
        Playground(
            component = {
                ProgressBar(percent = percent, paddingValues = FunBlocksInset.medium)
            }
        ) {}
    }
}
