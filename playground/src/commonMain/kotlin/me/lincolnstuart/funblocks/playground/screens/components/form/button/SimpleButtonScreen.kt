package me.lincolnstuart.funblocks.playground.screens.components.form.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.form.button.Button
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonOptions
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonType
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.playground.components.Sample

class SimpleButtonScreen : Screen {

    @Composable
    override fun Content() {
        var options by remember {
            mutableStateOf(ButtonOptions(isEnabled = false))
        }
        Sample(
            component = { Button(description = "Button", options = options) {} }
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
            SwitchButtonOption(
                description = "Enabled",
                isOn = options.isEnabled,
                onClick = { options = options.copy(isEnabled = options.isEnabled.not()) }
            )
            SwitchButtonOption(
                description = "Start Icon",
                isOn = options.startIcon != null,
                onClick = {
                    val icon = if (options.startIcon == null) TablerIcons.CircleDashed else null
                    options = options.copy(startIcon = icon)
                }
            )
            SwitchButtonOption(
                description = "End Icon",
                isOn = options.endIcon != null,
                onClick = {
                    val icon = if (options.endIcon == null) TablerIcons.CircleDashed else null
                    options = options.copy(endIcon = icon)
                }
            )
        }
    }
}
