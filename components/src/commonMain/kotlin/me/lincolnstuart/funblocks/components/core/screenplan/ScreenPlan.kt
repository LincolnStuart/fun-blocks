package me.lincolnstuart.funblocks.components.core.screenplan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.components.core.appbar.AppBar
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.bottomnavigator.BottomNavigator
import me.lincolnstuart.funblocks.components.core.bottomnavigator.utils.BottomNavigatorOptions
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

@Composable
public fun ScreenPlan(
    appBarOptions: AppBarOptions? = null,
    bottomNavigationOptions: BottomNavigatorOptions? = null,
    mainContent: (@Composable () -> Unit)? = null,
    secondaryContent: (@Composable () -> Unit)? = null
) {
    FunBlocksTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                appBarOptions?.let {
                    AppBar(options = appBarOptions)
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(color = FunBlocksColors.SurfaceMedium.value())
                ) {
                    mainContent?.invoke()
                }
                HorizontalDivider()
                secondaryContent?.invoke()
                bottomNavigationOptions?.let {
                    BottomNavigator(
                        options = bottomNavigationOptions
                    )
                }
            }
        }
    }
}
