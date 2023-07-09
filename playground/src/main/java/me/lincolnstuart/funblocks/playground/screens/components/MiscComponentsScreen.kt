package me.lincolnstuart.funblocks.playground.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.list.SimpleListItem
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.playground.screens.components.misc.BadgeScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.BannerScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.CardInfoScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.ChatMessageScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.ChipScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.DividerScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.ListScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.LoadingScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.NotificationScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.ProgressScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.RatingScreen
import me.lincolnstuart.funblocks.playground.screens.components.misc.SliderScreen

class MiscComponentsScreen : Screen {

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
                    screens
                        .sortedBy { it.first }
                        .forEach { componentScreen ->
                            SimpleListItem(title = componentScreen.first) {
                                navigator.push(componentScreen.second)
                            }
                        }
                }
            }
        }
    }

    private val screens = listOf(
        "Accordion" to me.lincolnstuart.funblocks.playground.screens.components.misc.AccordionScreen(),
        "Alert" to me.lincolnstuart.funblocks.playground.screens.components.misc.AlertScreen(),
        "Avatar" to me.lincolnstuart.funblocks.playground.screens.components.misc.AvatarScreen(),
        "Badge" to BadgeScreen(),
        "Banner" to BannerScreen(),
        "Card Info" to CardInfoScreen(),
        "Chat" to ChatMessageScreen(),
        "Chip" to ChipScreen(),
        "Divider" to DividerScreen(),
        "List" to ListScreen(),
        "Loading" to LoadingScreen(),
        "Notification" to NotificationScreen(),
        "Progress" to ProgressScreen(),
        "Rating" to RatingScreen(),
        "Slider" to SliderScreen()
    )
}
