package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.alert.Alert
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertCloseOptions
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.playground.components.Sample

class AlertScreen : Screen {

    @Composable
    override fun Content() {
        var mode: AlertMode by remember {
            mutableStateOf(AlertMode.Info)
        }
        var message: String? by remember {
            mutableStateOf(null)
        }
        var closeAction: (() -> Unit)? by remember {
            mutableStateOf(null)
        }
        Sample(
            component = {
                Alert(
                    title = "Alert",
                    mode = mode,
                    message = message,
                    closeOptions = AlertCloseOptions(onClose = closeAction)
                )
            }
        ) {
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
}
