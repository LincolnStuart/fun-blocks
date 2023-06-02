package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.list.utils.ListMode
import me.lincolnstuart.funblocks.sample.components.Playground

class ListScreen : Screen {

    @Composable
    override fun Content() {
        var mode: ListMode by remember {
            mutableStateOf(ListMode.Bulleted)
        }
        Playground(component = {
            me.lincolnstuart.funblocks.essentials.misc.list.List(
                topics = listOf("Kotlin", "Android", "Jetpack Compose"),
                mode = mode
            )
        }) {
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
