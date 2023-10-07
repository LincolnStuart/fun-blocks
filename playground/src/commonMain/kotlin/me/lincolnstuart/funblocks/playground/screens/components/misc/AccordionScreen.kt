package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.alert.Alert
import me.lincolnstuart.funblocks.components.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.playground.components.ComponentCentralizer

class AccordionScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Accordion", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentCentralizer {
                    Accordion(title = "Accordion") {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(FunBlocksSpacing.small)
                        ) {
                            Alert(title = "Content inside", mode = AlertMode.Warning)
                        }
                    }
                }
            }
        )
    }
}
