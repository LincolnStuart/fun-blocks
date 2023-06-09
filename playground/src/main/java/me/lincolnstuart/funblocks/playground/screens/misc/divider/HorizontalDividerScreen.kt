package me.lincolnstuart.funblocks.playground.screens.misc.divider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.essentials.misc.divider.utils.HorizontalDividerMode
import me.lincolnstuart.funblocks.playground.components.Sample

class HorizontalDividerScreen : Screen {

    @Composable
    override fun Content() {
        var mode: HorizontalDividerMode by remember {
            mutableStateOf(HorizontalDividerMode.Solid)
        }
        Sample(component = {
            HorizontalDivider(mode = mode)
        }) {
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
