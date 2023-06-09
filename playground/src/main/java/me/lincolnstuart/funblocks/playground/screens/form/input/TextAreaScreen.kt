package me.lincolnstuart.funblocks.playground.screens.form.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.input.TextArea
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.playground.components.Sample

class TextAreaScreen : Screen {

    @Composable
    override fun Content() {
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
        Sample(
            component = {
                TextArea(
                    value = inputValue,
                    onValueChange = { inputValue = it },
                    label = "Text area",
                    placeholder = "Enter your input",
                    enabled = enabled,
                    readOnly = readOnly,
                    error = error
                )
            }
        ) {
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
}
