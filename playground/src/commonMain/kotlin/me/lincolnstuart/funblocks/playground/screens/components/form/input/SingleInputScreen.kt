package me.lincolnstuart.funblocks.playground.screens.components.form.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.input.Input
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class SingleInputScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var error: String? by remember {
            mutableStateOf(null)
        }
        var enabled by remember {
            mutableStateOf(true)
        }
        var readOnly by remember {
            mutableStateOf(false)
        }
        var inputValue by remember {
            mutableStateOf("")
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "SingleInput", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    Input(
                        value = inputValue,
                        onValueChange = { inputValue = it },
                        label = "Input",
                        placeholder = "Enter your input",
                        enabled = enabled,
                        readOnly = readOnly,
                        error = error
                    )
                }) {
                    SwitchButtonOption(
                        description = "Enabled",
                        isOn = enabled,
                        onClick = { enabled = !enabled }
                    )
                    SwitchButtonOption(
                        description = "Read only",
                        isOn = readOnly,
                        onClick = { readOnly = !readOnly }
                    )
                    SwitchButtonOption(
                        description = "Error",
                        isOn = error != null,
                        onClick = { error = if (error == null) "some error" else null }
                    )
                }
            }
        )
    }
}
