package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.list.utils.ListMode
import me.lincolnstuart.funblocks.playground.components.Sample

class ListScreen : Screen {

    @Composable
    override fun Content() {
        var mode: ListMode by remember {
            mutableStateOf(ListMode.Bulleted)
        }
        Sample(
            component = {
                me.lincolnstuart.funblocks.components.misc.list.List(
                    topics = listOf("Kotlin", "Android", "Jetpack Compose"),
                    mode = mode
                )
            }
        ) {
            Accordion(title = "Mode") {
                RadioButtonGroup(
                    options = listOf(
                        ListMode.Bulleted,
                        ListMode.Enumerated
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
