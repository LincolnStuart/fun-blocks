package me.lincolnstuart.funblocks.foundation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksThemedColors
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * Composable theme with some tokens configurations.
 *
 * @param isDarkThemeApplied if dark mode is the choice.
 * @param theme to customize some tokens e.g. font-family, colors.
 * @param content the content inside.
 */
@Composable
fun FunBlocksTheme(
    isDarkThemeApplied: Boolean = isSystemInDarkTheme(),
    theme: Theme = Theme(),
    content: @Composable () -> Unit
) {
    val materialColors = remember(isDarkThemeApplied) {
        theme.colors.getMaterialColors(isDarkThemeApplied = isDarkThemeApplied)
    }
    LaunchedEffect(isDarkThemeApplied) {
        theme.colors.update(isDarkThemeApplied)
    }
    CompositionLocalProvider(
        LocalTheme provides theme
    ) {
        MaterialTheme(
            content = content,
            colors = materialColors
        )
    }
}

val LocalTheme = staticCompositionLocalOf { Theme() }

/**
 * Data class used to customize tokens.
 *
 * @param fontFamily a custom font-family.
 * @param colors a custom [FunBlocksThemedColors] with color tokens preset.
 */
@OptIn(ExperimentalResourceApi::class)
data class Theme(
    val fontFamily: FontFamily = FontFamily.SansSerif,
    val colors: FunBlocksThemedColors = FunBlocksThemedColors.Lego,
    val logo: @Composable (() -> Painter) = {
        painterResource("images/logo.webp")
    }
)
