package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import compose.icons.tablericons.CircleDashed
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.badge.Badge
import me.lincolnstuart.funblocks.components.misc.badge.utils.BadgeMode
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions

class BadgeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var mode: BadgeMode by remember {
            mutableStateOf(BadgeMode.Info)
        }
        var icon: ImageVector? by remember {
            mutableStateOf(null)
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Badge", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    Badge(
                        description = "Badge",
                        mode = mode,
                        startIcon = icon
                    )
                }) {
                    Accordion(title = "Mode") {
                        RadioButtonGroup(
                            options = listOf(
                                BadgeMode.Info,
                                BadgeMode.Warning,
                                BadgeMode.Success,
                                BadgeMode.Error
                            ),
                            selectedOption = mode,
                            onSelectOption = { mode = it }
                        ) {
                            Text(text = it.name)
                        }
                    }
                    SwitchButtonOption(
                        description = "Start Icon",
                        isOn = icon != null,
                        onClick = {
                            icon = if (icon == null) TablerIcons.CircleDashed else null
                        }
                    )
                }
            }
        )
    }
}
