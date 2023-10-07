package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.list.SimpleListItem
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.playground.screens.components.misc.notification.CounterNotificationScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.notification.IndicatorNotificationScreen

class NotificationScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Notification", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                Column(Modifier.verticalScroll(scrollState)) {
                    SimpleListItem(title = "Counter notification") {
                        navigator.push(CounterNotificationScreen())
                    }
                    SimpleListItem(title = "Indicator notification") {
                        navigator.push(IndicatorNotificationScreen())
                    }
                }
            }
        )
    }
}
