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
import me.lincolnstuart.funblocks.essentials.misc.divider.VerticalDivider
import me.lincolnstuart.funblocks.essentials.misc.divider.utils.VerticalDividerMode
import me.lincolnstuart.funblocks.playground.components.Sample

class VerticalDividerScreen : Screen {

    @Composable
    override fun Content() {
        var mode: VerticalDividerMode by remember {
            mutableStateOf(VerticalDividerMode.Solid)
        }
        Sample(component = {
            VerticalDivider(mode = mode)
        }) {
            Accordion(title = "Mode") {
                RadioButtonGroup(
                    options = listOf(
                        VerticalDividerMode.Solid,
                        VerticalDividerMode.Dashed,
                        VerticalDividerMode.Dotted
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
