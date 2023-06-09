package me.lincolnstuart.funblocks.playground.screens.components.misc.notification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar
import me.lincolnstuart.funblocks.essentials.misc.notification.CounterNotification
import me.lincolnstuart.funblocks.playground.components.Sample

class CounterNotificationScreen : Screen {

    @Composable
    override fun Content() {
        var counter by remember {
            mutableStateOf(0)
        }
        Sample(
            component = { CounterNotification(number = counter) { Avatar {} } }
        ) {
            SwitchButtonOption(
                description = "Has notification",
                isOn = counter > 0,
                onClick = {
                    counter = if (counter == 0) 1 else 0
                }
            )
        }
    }
}
