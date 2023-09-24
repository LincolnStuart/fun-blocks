package me.lincolnstuart.funblocks.playground.screens.components.form

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import compose.icons.tablericons.BrandAndroid
import compose.icons.tablericons.BrandApple
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.tabs.Tabs
import me.lincolnstuart.funblocks.components.form.tabs.utils.TabOption
import me.lincolnstuart.funblocks.components.misc.alert.Alert

class TabsScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Tabs", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            mainContent = {
                Tabs(
                    options = listOf(
                        TabOption(
                            icon = TablerIcons.BrandAndroid,
                            label = "Android",
                            content = { Alert(title = "Android info") }
                        ),
                        TabOption(
                            icon = TablerIcons.BrandApple,
                            label = "iOS",
                            content = { Alert(title = "iOS info") }
                        )
                    )
                )
            }
        )
    }
}
