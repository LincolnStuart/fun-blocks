package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.chip.Chip
import me.lincolnstuart.funblocks.essentials.misc.chip.utils.ChipOptions
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

class ChipScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ChipPlaygroundOptions()
            }
        }
    }

    @Composable
    private fun ChipPlaygroundOptions() {
        Column {
            var options: ChipOptions by remember {
                mutableStateOf(ChipOptions())
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = FunBlocksColors.SurfaceMedium.value()),
                contentAlignment = Alignment.Center
            ) {
                Chip(
                    description = "Chip",
                    options = options
                ) {}
            }
            HorizontalDivider()
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
