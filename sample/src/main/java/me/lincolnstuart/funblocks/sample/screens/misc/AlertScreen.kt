package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.alert.Alert
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertCloseOptions
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

class AlertScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AlertPlaygroundOptions()
            }
        }
    }

    @Composable
    private fun AlertPlaygroundOptions() {
        var mode: AlertMode by remember {
            mutableStateOf(AlertMode.Info)
        }
        var message: String? by remember {
            mutableStateOf(null)
        }
        var closeAction: (() -> Unit)? by remember {
            mutableStateOf(null)
        }
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = FunBlocksColors.SurfaceMedium.value())
                    .padding(FunBlocksSpacing.small),
                contentAlignment = Alignment.Center
            ) {
                Alert(
                    title = "Alert",
                    mode = mode,
                    message = message,
                    closeOptions = AlertCloseOptions(onClose = closeAction)
                )
            }
            HorizontalDivider()
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
