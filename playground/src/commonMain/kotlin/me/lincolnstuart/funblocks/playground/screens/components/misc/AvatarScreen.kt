package me.lincolnstuart.funblocks.playground.screens.components.misc

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
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.avatar.Avatar
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarMode
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class AvatarScreen : Screen {

    @Composable
    @OptIn(ExperimentalResourceApi::class)
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val iconMode = AvatarMode.Icon()
        val imageMode = AvatarMode.Image(
            painter = painterResource("images/fun_blocks.webp")
        )
        val initialsMode = AvatarMode.Initials("Lincoln Stuart")
        var mode: AvatarMode by remember {
            mutableStateOf(iconMode)
        }
        var shape by remember {
            mutableStateOf(AvatarShape.Circle)
        }
        var size by remember {
            mutableStateOf(AvatarSize.Regular)
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Avatar", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    Avatar(
                        mode = mode,
                        options = AvatarOptions(shape, size)
                    ) {}
                }) {
                    Accordion(title = "Mode") {
                        RadioButtonGroup(
                            options = listOf(iconMode, imageMode, initialsMode),
                            selectedOption = mode,
                            onSelectOption = { mode = it }
                        ) {
                            Text(text = it.javaClass.simpleName)
                        }
                    }
                    Accordion(title = "Shape") {
                        RadioButtonGroup(
                            options = listOf(AvatarShape.Circle, AvatarShape.Square),
                            selectedOption = shape,
                            onSelectOption = { shape = it }
                        ) {
                            Text(text = it.name)
                        }
                    }
                    Accordion(title = "Size") {
                        RadioButtonGroup(
                            options = listOf(
                                AvatarSize.Small,
                                AvatarSize.Regular,
                                AvatarSize.Large
                            ),
                            selectedOption = size,
                            onSelectOption = { size = it }
                        ) {
                            Text(text = it.name)
                        }
                    }
                }
            }
        )
    }
}
