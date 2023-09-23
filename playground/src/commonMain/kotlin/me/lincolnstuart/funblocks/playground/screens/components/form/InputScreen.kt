package me.lincolnstuart.funblocks.playground.screens.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.lincolnstuart.funblocks.components.core.list.SimpleListItem
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.playground.screens.components.form.input.IncrementerScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.input.PinScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.input.SingleInputScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.input.TextAreaScreen

class InputScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val navigator = LocalNavigator.currentOrThrow
                val scrollState = rememberScrollState()
                Column(Modifier.verticalScroll(scrollState)) {
                    SimpleListItem(title = "Incrementer") {
                        navigator.push(IncrementerScreen())
                    }
                    SimpleListItem(title = "Input") {
                        navigator.push(SingleInputScreen())
                    }
                    SimpleListItem(title = "Pin") {
                        navigator.push(PinScreen())
                    }
                    SimpleListItem(title = "TextArea") {
                        navigator.push(TextAreaScreen())
                    }
                }
            }
        }
    }
}
