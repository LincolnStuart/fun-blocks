package me.lincolnstuart.funblocks.playground.screens.components.form.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.input.pin.Pin
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.playground.components.Sample

class PinScreen : Screen {

    @Composable
    override fun Content() {
        var error: String? by remember {
            mutableStateOf(null)
        }
        var isCharactersShowed by remember {
            mutableStateOf(true)
        }
        var inputValue by remember {
            mutableStateOf("")
        }
        Sample(
            component = {
                Pin(
                    value = inputValue,
                    onValueChange = { inputValue = it },
                    label = "Pin",
                    error = error,
                    isCharactersHide = isCharactersShowed.not(),
                    size = 6
                )
            }
        ) {
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
}
