package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.loading.Loading
import me.lincolnstuart.funblocks.playground.components.Sample

class LoadingScreen : Screen {

    @Composable
    override fun Content() {
        Sample(
            component = { Loading() }
        ) {}
    }
}
