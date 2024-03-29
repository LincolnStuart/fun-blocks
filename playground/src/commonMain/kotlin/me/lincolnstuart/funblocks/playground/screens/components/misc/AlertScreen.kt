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
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.alert.Alert
import me.lincolnstuart.funblocks.components.misc.alert.utils.AlertCloseOptions
import me.lincolnstuart.funblocks.components.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class AlertScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var mode: AlertMode by remember {
            mutableStateOf(AlertMode.Info)
        }
        var message: String? by remember {
            mutableStateOf(null)
        }
        var closeAction: (() -> Unit)? by remember {
            mutableStateOf(null)
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Alert", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    Alert(
                        title = "Alert",
                        mode = mode,
                        message = message,
                        closeOptions = AlertCloseOptions(onClose = closeAction)
                    )
                }) {
                    Accordion(title = "Mode") {
                        RadioButtonGroup(
                            options = listOf(
                                AlertMode.Info,
                                AlertMode.Warning,
                                AlertMode.Success,
                                AlertMode.Error
                            ),
                            selectedOption = mode,
                            onSelectOption = { mode = it }
                        ) {
                            Text(text = it.name)
                        }
                    }
                    SwitchButtonOption(
                        description = "Message",
                        isOn = message != null,
                        onClick = {
                            message = if (message == null) "Message" else null
                        }
                    )
                    SwitchButtonOption(
                        description = "Close",
                        isOn = closeAction != null,
                        onClick = {
                            closeAction = if (closeAction == null) fun() { Unit } else null
                        }
                    )
                }
            }
        )
    }
}
