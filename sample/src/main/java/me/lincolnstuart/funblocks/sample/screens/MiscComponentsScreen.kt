package me.lincolnstuart.funblocks.sample.screens

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
import me.lincolnstuart.funblocks.sample.screens.misc.AccordionScreen
import me.lincolnstuart.funblocks.sample.screens.misc.AlertScreen
import me.lincolnstuart.funblocks.sample.screens.misc.AvatarScreen
import me.lincolnstuart.funblocks.sample.screens.misc.BadgeScreen
import me.lincolnstuart.funblocks.sample.screens.misc.BannerScreen
import me.lincolnstuart.funblocks.sample.screens.misc.CardInfoScreen
import me.lincolnstuart.funblocks.sample.screens.misc.ChatMessageScreen
import me.lincolnstuart.funblocks.sample.screens.misc.ChipScreen
import me.lincolnstuart.funblocks.sample.screens.misc.DividerScreen
import me.lincolnstuart.funblocks.sample.screens.misc.ListScreen
import me.lincolnstuart.funblocks.sample.screens.misc.LoadingScreen
import me.lincolnstuart.funblocks.sample.screens.misc.NotificationScreen
import me.lincolnstuart.funblocks.sample.screens.misc.RatingScreen

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
        "Accordion" to AccordionScreen(),
        "Alert" to AlertScreen(),
        "Avatar" to AvatarScreen(),
        "Badge" to BadgeScreen(),
        "Banner" to BannerScreen(),
        "Card Info" to CardInfoScreen(),
        "Chat" to ChatMessageScreen(),
        "Chip" to ChipScreen(),
        "Divider" to DividerScreen(),
        "List" to ListScreen(),
        "Loading" to LoadingScreen(),
        "Notification" to NotificationScreen(),
        "Rating" to RatingScreen()
    )
}
