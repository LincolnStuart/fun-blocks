package me.lincolnstuart.funblocks.playground.screens.components.misc.divider

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
import me.lincolnstuart.funblocks.components.misc.divider.VerticalDivider
import me.lincolnstuart.funblocks.components.misc.divider.utils.VerticalDividerMode
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class VerticalDividerScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var mode: VerticalDividerMode by remember {
            mutableStateOf(VerticalDividerMode.Solid)
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "VerticalDivider", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
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
        )
    }
}
