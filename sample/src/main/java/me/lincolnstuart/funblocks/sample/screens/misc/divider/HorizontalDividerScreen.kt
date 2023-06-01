package me.lincolnstuart.funblocks.sample.screens.misc.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.essentials.misc.divider.utils.HorizontalDividerMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

class HorizontalDividerScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                HorizontalDividerPlaygroundOptions()
            }
        }
    }

    @Composable
    private fun HorizontalDividerPlaygroundOptions() {
        Column {
            var mode: HorizontalDividerMode by remember {
                mutableStateOf(HorizontalDividerMode.Solid)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = FunBlocksColors.SurfaceMedium.value())
                    .padding(FunBlocksSpacing.small),
                contentAlignment = Alignment.Center
            ) {
                HorizontalDivider(mode = mode)
            }
            HorizontalDivider()
            Accordion(title = "Mode") {
                RadioButtonGroup(
                    options = listOf(
                        HorizontalDividerMode.Solid,
                        HorizontalDividerMode.Dashed,
                        HorizontalDividerMode.Dotted
                    ),
                    selectedOption = mode,
                    onSelectOption = { mode = it }
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}
