package me.lincolnstuart.funblocks.playground.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.BrandGithub
import me.lincolnstuart.funblocks.components.core.list.SimpleListItem
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.misc.chip.Chip
import me.lincolnstuart.funblocks.components.misc.chip.utils.ChipOptions
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.playground.components.Sample
import me.lincolnstuart.funblocks.playground.screens.components.HomeComponentsScreen
import me.lincolnstuart.funblocks.playground.screens.tokens.HomeTokensScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.orEmpty
import org.jetbrains.compose.resources.rememberImageVector
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalResourceApi::class)
class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val uriHandler = LocalUriHandler.current
        Sample(
            component = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = spacedBy(FunBlocksSpacing.xxSmall)
                ) {
                    // TODO fix image reference from resources
                    Image(
                        imageVector = resource("images/fun_blocks.webp")
                            .rememberImageVector(LocalDensity.current)
                            .orEmpty(),
                        contentDescription = "Fun Blocks Brand",
                        modifier = Modifier.height(FunBlocksContentSize.huge)
                    )
                    Text(text = "Fun Blocks Playground", mode = TextMode.Title())
                    Chip(
                        description = "Repo",
                        options = ChipOptions(isSelected = true, endIcon = TablerIcons.BrandGithub)
                    ) {
                        uriHandler.openUri("https://github.com/LincolnStuart/fun-blocks")
                    }
                }
            }
        ) {
            SimpleListItem(title = "Tokens", description = "Color, Size, Spacing, etc.") {
                navigator.push(HomeTokensScreen())
            }
            SimpleListItem(
                title = "Components",
                description = "Avatar, Button, Chart, etc."
            ) {
                navigator.push(HomeComponentsScreen())
            }
        }
    }
}
