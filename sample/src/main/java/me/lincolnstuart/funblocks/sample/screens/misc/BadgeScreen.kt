package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButton
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.badge.Badge
import me.lincolnstuart.funblocks.essentials.misc.badge.utils.BadgeMode
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

class BadgeScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                BadgeOptions()
            }
        }
    }

    @Composable
    private fun BadgeOptions() {
        var mode: BadgeMode by remember {
            mutableStateOf(BadgeMode.Info)
        }
        var icon: ImageVector? by remember {
            mutableStateOf(null)
        }
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = FunBlocksColors.SurfaceMedium.value()),
                contentAlignment = Alignment.Center
            ) {
                Badge(
                    description = "Badge",
                    mode = mode,
                    startIcon = icon
                )
            }
            HorizontalDivider()
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FunBlocksColors.Surface.value())
                    .padding(FunBlocksSpacing.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Start Icon",
                    mode = TextMode.Subtitle(),
                    modifier = Modifier.weight(1f)
                )
                SwitchButton(
                    isOn = icon != null,
                    onClick = {
                        icon = if (icon == null) TablerIcons.CircleDashed else null
                    }
                )
            }
        }
    }
}
