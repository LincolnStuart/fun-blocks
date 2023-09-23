package me.lincolnstuart.funblocks.playground.screens.components.form.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.button.timer.TimerButton
import me.lincolnstuart.funblocks.essentials.form.button.timer.utils.TimerButtonOptions
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonType
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.playground.components.Sample

class TimerButtonScreen : Screen {

    @Composable
    override fun Content() {
        var options by remember {
            mutableStateOf(TimerButtonOptions(blockingTimeInSeconds = 5))
        }
        Sample(
            component = { TimerButton(description = "Button", options = options) {} }
        ) {
            Accordion(title = "Mode") {
                RadioButtonGroup(
                    options = listOf(
                        ButtonMode.Primary,
                        ButtonMode.Secondary,
                        ButtonMode.Danger,
                        ButtonMode.Ghost
                    ),
                    selectedOption = options.mode,
                    onSelectOption = { options = options.copy(mode = it) }
                ) {
                    Text(text = it.name)
                }
            }
            Accordion(title = "Type") {
                RadioButtonGroup(
                    options = listOf(
                        ButtonType.Small,
                        ButtonType.Regular
                    ),
                    selectedOption = options.type,
                    onSelectOption = { options = options.copy(type = it) }
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}
