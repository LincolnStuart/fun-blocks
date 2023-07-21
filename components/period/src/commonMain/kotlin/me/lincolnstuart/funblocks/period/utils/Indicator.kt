package me.lincolnstuart.funblocks.period.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Indicator that paint a background behind the content when it is visible
 *
 * @param onClick callback to execute an action when click is performed.
 * @param isVisible if indicator is visible.
 * @param color indicator background [FunBlocksColors].
 * @param content the content inside.
 */
@Composable
internal fun RowScope.Indicator(
    onClick: () -> Unit,
    isVisible: Boolean = true,
    color: FunBlocksColors = FunBlocksColors.Primary,
    content: @Composable () -> Unit
) {
    val backgroundColor = remember(isVisible) {
        if (isVisible) color else FunBlocksColors.Transparent
    }
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(CircleShape)
            .background(backgroundColor.value())
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
