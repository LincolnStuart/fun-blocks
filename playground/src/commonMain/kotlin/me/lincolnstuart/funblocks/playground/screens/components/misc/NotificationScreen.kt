package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.lincolnstuart.funblocks.components.core.list.SimpleListItem
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.playground.screens.components.misc.notification.CounterNotificationScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.notification.IndicatorNotificationScreen

class NotificationScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val navigator = LocalNavigator.currentOrThrow
                val scrollState = rememberScrollState()
                Column(Modifier.verticalScroll(scrollState)) {
                    SimpleListItem(title = "Counter notification") {
                        navigator.push(CounterNotificationScreen())
                    }
                    SimpleListItem(title = "Indicator notification") {
                        navigator.push(IndicatorNotificationScreen())
                    }
                }
            }
        }
    }
}
