package me.lincolnstuart.funblocks.sample.screens.form

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.button.Button
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonOptions
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonType
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.sample.components.Playground

class ButtonScreen : Screen {

    @Composable
    override fun Content() {
        var options by remember {
            mutableStateOf(ButtonOptions(isEnabled = false))
        }
        Playground(
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
