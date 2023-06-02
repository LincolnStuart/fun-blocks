package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.chip.Chip
import me.lincolnstuart.funblocks.essentials.misc.chip.utils.ChipOptions
import me.lincolnstuart.funblocks.sample.components.Playground

class ChipScreen : Screen {

    @Composable
    override fun Content() {
        var options: ChipOptions by remember {
            mutableStateOf(ChipOptions())
        }
        Playground(component = {
            Chip(
                description = "Chip",
                options = options
            ) {}
        }) {
            SwitchButtonOption(
                description = "Enabled",
                isOn = options.isEnabled,
                onClick = {
                    options = options.copy(isEnabled = options.isEnabled.not())
                }
            )
            SwitchButtonOption(
                description = "Selected",
                isOn = options.isSelected,
                onClick = {
                    options = options.copy(isSelected = options.isSelected.not())
                }
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
