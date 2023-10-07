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
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.list.utils.ListMode
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class ListScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var mode: ListMode by remember {
            mutableStateOf(ListMode.Bulleted)
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "List", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    me.lincolnstuart.funblocks.components.misc.list.List(
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
        )
    }
}
