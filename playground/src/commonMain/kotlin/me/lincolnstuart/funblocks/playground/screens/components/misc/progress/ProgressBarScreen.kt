package me.lincolnstuart.funblocks.playground.screens.components.misc.progress

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
import me.lincolnstuart.funblocks.playground.components.Sample

class ProgressBarScreen : Screen {

    @Composable
    override fun Content() {
        var percent by remember {
            mutableStateOf(0f)
        }
        LaunchedEffect(Unit) {
            delay(timeMillis = 2000)
            percent = TWENTY_FIVE_PERCENT
            delay(timeMillis = 2000)
            percent = SEVENTY_FIVE_PERCENT
            delay(timeMillis = 2000)
            percent = ONE_HUNDRED_PERCENT
        }
        Sample(
            component = { ProgressBar(percent = percent, paddingValues = FunBlocksInset.medium) }
        ) {}
    }

    private companion object {
        const val TWENTY_FIVE_PERCENT = 25f
        const val SEVENTY_FIVE_PERCENT = 75f
        const val ONE_HUNDRED_PERCENT = 100f
    }
}
