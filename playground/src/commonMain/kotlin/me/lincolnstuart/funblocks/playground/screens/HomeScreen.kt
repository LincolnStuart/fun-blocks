package me.lincolnstuart.funblocks.playground.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.BrandGithub
import compose.icons.tablericons.BuildingBridge2
import compose.icons.tablericons.ColorSwatch
import me.lincolnstuart.funblocks.components.core.bottomnavigator.utils.BottomNavigationItemAction
import me.lincolnstuart.funblocks.components.core.bottomnavigator.utils.BottomNavigatorOptions
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.misc.chip.Chip
import me.lincolnstuart.funblocks.components.misc.chip.utils.ChipOptions
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.playground.components.ComponentCentralizer
import me.lincolnstuart.funblocks.playground.screens.components.HomeComponentsScreen
import me.lincolnstuart.funblocks.playground.screens.tokens.HomeTokensScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val uriHandler = LocalUriHandler.current
        ScreenPlan(
            bottomNavigationOptions = BottomNavigatorOptions(
                items =
                listOf(
                    BottomNavigationItemAction(
                        icon = TablerIcons.ColorSwatch,
                        label = "Tokens",
                        callback = { navigator.push(HomeTokensScreen()) }
                    ),
                    BottomNavigationItemAction(
                        icon = TablerIcons.BuildingBridge2,
                        label = "Components",
                        callback = { navigator.push(HomeComponentsScreen()) }
                    )
                )
            ),
            mainContent = {
                ComponentCentralizer {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = spacedBy(FunBlocksSpacing.xxSmall)
                    ) {
                        // TODO fix image reference from resources
                        Image(
                            painter = painterResource("images/fun_blocks.webp"),
                            contentDescription = "Fun Blocks Brand",
                            modifier = Modifier.height(FunBlocksContentSize.huge)
                        )
                        Text(text = "Fun Blocks Playground", mode = TextMode.Title())
                        Chip(
                            description = "Repo",
                            options = ChipOptions(
                                isSelected = true,
                                endIcon = TablerIcons.BrandGithub
                            )
                        ) {
                            uriHandler.openUri("https://github.com/LincolnStuart/fun-blocks")
                        }
                    }
                }
            }
        )
    }
}
