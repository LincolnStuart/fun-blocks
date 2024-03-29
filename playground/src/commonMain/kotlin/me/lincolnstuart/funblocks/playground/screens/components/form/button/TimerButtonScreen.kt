package me.lincolnstuart.funblocks.playground.screens.components.form.button

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
import me.lincolnstuart.funblocks.components.form.button.timer.TimerButton
import me.lincolnstuart.funblocks.components.form.button.timer.utils.TimerButtonOptions
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonType
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class TimerButtonScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var options by remember {
            mutableStateOf(TimerButtonOptions(blockingTimeInSeconds = 5))
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "TimerButton", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    TimerButton(description = "Button", options = options) {}
                }) {
                    Accordion(title = "Mode") {
                        RadioButtonGroup(
                            options = listOf(
                                ButtonMode.Primary,
                                ButtonMode.Secondary,
                                ButtonMode.Danger,
                                ButtonMode.Ghost
                            ),
                            selectedOption = options.mode,
                            onSelectOption = { options = options.copy(mode = it) }
                        ) {
                            Text(text = it.name)
                        }
                    }
                    Accordion(title = "Type") {
                        RadioButtonGroup(
                            options = listOf(
                                ButtonType.Small,
                                ButtonType.Regular
                            ),
                            selectedOption = options.type,
                            onSelectOption = { options = options.copy(type = it) }
                        ) {
                            Text(text = it.name)
                        }
                    }
                }
            }
        )
    }
}
