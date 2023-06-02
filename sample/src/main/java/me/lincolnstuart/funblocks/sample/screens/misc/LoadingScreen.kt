package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.loading.Loading
import me.lincolnstuart.funblocks.sample.components.Playground

class LoadingScreen : Screen {

    @Composable
    override fun Content() {
        Playground(component = {
            Loading()
        }) {}
    }
}
