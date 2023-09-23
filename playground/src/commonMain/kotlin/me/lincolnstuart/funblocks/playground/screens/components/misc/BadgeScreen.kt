package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.badge.Badge
import me.lincolnstuart.funblocks.essentials.misc.badge.utils.BadgeMode
import me.lincolnstuart.funblocks.playground.components.Sample

class BadgeScreen : Screen {

    @Composable
    override fun Content() {
        var mode: BadgeMode by remember {
            mutableStateOf(BadgeMode.Info)
        }
        var icon: ImageVector? by remember {
            mutableStateOf(null)
        }
        Sample(
            component = {
                Badge(
                    description = "Badge",
                    mode = mode,
                    startIcon = icon
                )
            }
        ) {
            Accordion(title = "Mode") {
                RadioButtonGroup(
                    options = listOf(
                        BadgeMode.Info,
                        BadgeMode.Warning,
                        BadgeMode.Success,
                        BadgeMode.Error
                    ),
                    selectedOption = mode,
                    onSelectOption = { mode = it }
                ) {
                    Text(text = it.name)
                }
            }
            SwitchButtonOption(
                description = "Start Icon",
                isOn = icon != null,
                onClick = {
                    icon = if (icon == null) TablerIcons.CircleDashed else null
                }
            )
        }
    }
}
