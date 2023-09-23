package me.lincolnstuart.funblocks.playground.screens.components.misc

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
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.components.misc.chip.Chip
import me.lincolnstuart.funblocks.components.misc.chip.utils.ChipOptions
import me.lincolnstuart.funblocks.playground.components.ComponentCentralizer

class ChipScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var options: ChipOptions by remember {
            mutableStateOf(ChipOptions())
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Chip", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            mainContent = {
                ComponentCentralizer {
                    Chip(
                        description = "Chip",
                        options = options
                    ) {}
                }
            }
        ) {
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
