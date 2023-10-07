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
import me.lincolnstuart.funblocks.components.form.input.pin.Pin
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class PinScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var error: String? by remember {
            mutableStateOf(null)
        }
        var isCharactersShowed by remember {
            mutableStateOf(true)
        }
        var inputValue by remember {
            mutableStateOf("")
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Pin", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    Pin(
                        value = inputValue,
                        onValueChange = { inputValue = it },
                        label = "Pin",
                        error = error,
                        isCharactersHide = isCharactersShowed.not(),
                        size = 6
                    )
                }) {
                    SwitchButtonOption(
                        description = "Show Characters",
                        isOn = isCharactersShowed,
                        onClick = { isCharactersShowed = !isCharactersShowed }
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
