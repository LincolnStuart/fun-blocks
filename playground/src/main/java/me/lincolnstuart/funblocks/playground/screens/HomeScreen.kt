package me.lincolnstuart.funblocks.playground.screens

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat.startActivity
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.BrandGithub
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.list.SimpleListItem
import me.lincolnstuart.funblocks.essentials.misc.chip.Chip
import me.lincolnstuart.funblocks.essentials.misc.chip.utils.ChipOptions
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.playground.R
import me.lincolnstuart.funblocks.playground.components.Sample
import me.lincolnstuart.funblocks.playground.screens.components.HomeComponentsScreen
import me.lincolnstuart.funblocks.playground.screens.tokens.HomeTokensScreen

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val context = LocalContext.current
        Sample(
            component = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = spacedBy(FunBlocksSpacing.xxSmall)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fun_blocks),
                        contentDescription = "Fun Blocks Brand",
                        modifier = Modifier.height(FunBlocksContentSize.huge)
                    )
                    Text(text = "Fun Blocks Playground", mode = TextMode.Title())
                    Chip(
                        description = "Repo",
                        options = ChipOptions(isSelected = true, endIcon = TablerIcons.BrandGithub)
                    ) {
                        val browserIntent = Intent(
                            ACTION_VIEW,
                            Uri.parse("https://github.com/LincolnStuart/fun-blocks")
                        )
                        startActivity(context, browserIntent, null)
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
