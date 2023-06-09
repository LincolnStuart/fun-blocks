package me.lincolnstuart.funblocks.playground.screens.components.misc.notification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar
import me.lincolnstuart.funblocks.essentials.misc.notification.IndicatorNotification
import me.lincolnstuart.funblocks.playground.components.Sample

class IndicatorNotificationScreen : Screen {

    @Composable
    override fun Content() {
        var hasNotification by remember {
            mutableStateOf(false)
        }
        Sample(
            component = { IndicatorNotification(hasNotification = hasNotification) { Avatar {} } }
        ) {
            SwitchButtonOption(
                description = "Has notification",
                isOn = hasNotification,
                onClick = {
                    hasNotification = !hasNotification
                }
            )
        }
    }
}
