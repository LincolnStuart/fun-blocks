package me.lincolnstuart.funblocks.playground.screens.components.misc.divider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.divider.VerticalDivider
import me.lincolnstuart.funblocks.components.misc.divider.utils.VerticalDividerMode
import me.lincolnstuart.funblocks.playground.components.Sample

class VerticalDividerScreen : Screen {

    @Composable
    override fun Content() {
        var mode: VerticalDividerMode by remember {
            mutableStateOf(VerticalDividerMode.Solid)
        }
        Sample(
            component = { VerticalDivider(mode = mode) }
        ) {
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
