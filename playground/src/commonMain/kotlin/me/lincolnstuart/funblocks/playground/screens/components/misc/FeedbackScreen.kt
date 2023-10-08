package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
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
import me.lincolnstuart.funblocks.components.misc.feedback.Feedback
import me.lincolnstuart.funblocks.components.misc.feedback.utils.FeedbackMode
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class FeedbackScreen : Screen {

    @Composable
    @OptIn(ExperimentalResourceApi::class)
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Banner", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                Feedback(
                    mode = FeedbackMode.Basic(
                        title = "Congratulations!",
                        painter = painterResource("images/fun_blocks.webp"),
                        painterDescription = null,
                        details = "You are testing our design system."
                    )
                )
            }
        )
    }
}
