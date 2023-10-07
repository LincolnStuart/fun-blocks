package me.lincolnstuart.funblocks.playground.screens.components

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
import me.lincolnstuart.funblocks.playground.screens.components.period.CalendarScreen

class PeriodComponentsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Period", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                Column(Modifier.verticalScroll(scrollState)) {
                    screens
                        .sortedBy { it.first }
                        .forEach { componentScreen ->
                            SimpleListItem(title = componentScreen.first) {
                                navigator.push(componentScreen.second)
                            }
                        }
                }
            }
        )
    }

    private val screens = listOf(
        "Calendar" to CalendarScreen()
    )
}
