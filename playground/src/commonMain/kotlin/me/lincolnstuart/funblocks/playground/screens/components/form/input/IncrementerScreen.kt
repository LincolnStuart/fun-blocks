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
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.input.incrementer.Incrementer
import me.lincolnstuart.funblocks.components.form.input.incrementer.utils.IncrementerOptions
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.playground.components.Sample

class IncrementerScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var isResetAllowed by remember {
            mutableStateOf(true)
        }
        var inputValue by remember {
            mutableStateOf(value = 5)
        }
        Sample(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Incrementer", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            component = {
                Incrementer(
                    description = "Incrementer item",
                    value = inputValue,
                    onValueChange = { inputValue = it },
                    options = IncrementerOptions(
                        isResetAllowed = isResetAllowed,
                        minValue = 0,
                        maxValue = 10
                    )
                )
            }
        ) {
            SwitchButtonOption(
                description = "Reset allowed",
                isOn = isResetAllowed,
                onClick = { isResetAllowed = !isResetAllowed }
            )
        }
    }
}
