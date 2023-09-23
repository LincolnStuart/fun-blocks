package me.lincolnstuart.funblocks.playground.screens.components.misc.notification

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
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.components.misc.avatar.Avatar
import me.lincolnstuart.funblocks.components.misc.notification.CounterNotification
import me.lincolnstuart.funblocks.playground.components.Sample

class CounterNotificationScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var counter by remember {
            mutableStateOf(0)
        }
        Sample(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "CounterNotification", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
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
