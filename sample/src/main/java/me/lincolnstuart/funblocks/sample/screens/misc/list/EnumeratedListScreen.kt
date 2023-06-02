package me.lincolnstuart.funblocks.sample.screens.misc.list

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.list.EnumeratedList
import me.lincolnstuart.funblocks.sample.components.Playground

class EnumeratedListScreen : Screen {

    @Composable
    override fun Content() {
        Playground(component = {
            EnumeratedList(
                topics = listOf("Kotlin", "Android", "Jetpack Compose")
            )
        }) {}
    }
}
