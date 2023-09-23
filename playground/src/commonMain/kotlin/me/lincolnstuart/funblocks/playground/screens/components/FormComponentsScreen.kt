package me.lincolnstuart.funblocks.playground.screens.components

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
import me.lincolnstuart.funblocks.playground.screens.components.form.ButtonScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.CheckboxScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.InputScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.RadioButtonScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.SelectScreen
import me.lincolnstuart.funblocks.playground.screens.components.form.SwitchButtonScreen

class FormComponentsScreen : Screen {

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
                    screens
                        .sortedBy { it.first }
                        .forEach { componentScreen ->
                            SimpleListItem(title = componentScreen.first) {
                                navigator.push(componentScreen.second)
                            }
                        }
                }
            }
        }
    }

    private val screens = listOf(
        "Button" to ButtonScreen(),
        "Checkbox" to CheckboxScreen(),
        "Input" to InputScreen(),
        "RadioButton" to RadioButtonScreen(),
        "Select" to SelectScreen(),
        "SwitchButton" to SwitchButtonScreen()
    )
}
