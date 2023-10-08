package me.lincolnstuart.funblocks.components.core.screenplan

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.components.core.appbar.AppBar
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.bottomnavigator.BottomNavigator
import me.lincolnstuart.funblocks.components.core.bottomnavigator.utils.BottomNavigatorOptions
import me.lincolnstuart.funblocks.components.core.screenplan.utils.snackbar.Snackbar
import me.lincolnstuart.funblocks.components.core.screenplan.utils.snackbar.SnackbarOptions
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

@Composable
public fun ScreenPlan(
    appBarOptions: AppBarOptions? = null,
    bottomNavigationOptions: BottomNavigatorOptions? = null,
    snackbarOptions: SnackbarOptions? = null,
    content: (@Composable () -> Unit)? = null
) {
    var isSnackbarEnabled by remember(snackbarOptions) {
        mutableStateOf(snackbarOptions != null)
    }
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
                    content?.invoke()
                }
                snackbarOptions?.let {
                    AnimatedVisibility(isSnackbarEnabled) {
                        Column(verticalArrangement = Arrangement.Bottom) {
                            Snackbar(options = snackbarOptions) {
                                isSnackbarEnabled = false
                            }
                        }
                    }
                }
                bottomNavigationOptions?.let {
                    BottomNavigator(
                        options = bottomNavigationOptions
                    )
                }
            }
        }
    }
}
