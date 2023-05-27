package me.lincolnstuart.funblocks.sample.screens.misc.avatar

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

class AvatarScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(Modifier.verticalScroll(scrollState)) {
                    SimpleListItem(title = "IconAvatar") {
                        navigator.push(IconAvatarScreen())
                    }
                    SimpleListItem(title = "ImageAvatar") {
                        navigator.push(ImageAvatarScreen())
                    }
                    SimpleListItem(title = "InitialsAvatar") {
                        navigator.push(InitialsAvatarScreen())
                    }
                }
            }
        }
    }
}
