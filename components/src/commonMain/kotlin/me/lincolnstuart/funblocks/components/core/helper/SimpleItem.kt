package me.lincolnstuart.funblocks.components.core.helper

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Reusable row item with icons at the start and the end and a content in the middle.
 *
 * @param modifier optional [Modifier].
 * @param startIcon optional [ImageVector] that will be showed at the start of this component.
 * @param endIcon optional [ImageVector] that will be showed at the end of this component.
 * @param iconColor [FunBlocksColors] of the start and end icons.
 * @param iconSize [IconSize].
 * @param content the content inside.
 */
@Composable
internal fun SimpleItem(
    modifier: Modifier = Modifier,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    iconColor: FunBlocksColors = FunBlocksColors.Neutral,
    iconSize: IconSize = IconSize.Small,
    content: @Composable BoxScope.() -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        startIcon?.let {
            Icon(
                imageVector = startIcon,
                options = IconOptions(
                    description = null,
                    size = iconSize,
                    color = iconColor
                )
            )
        }
        Box(
            Modifier
                .padding(horizontal = FunBlocksSpacing.xxxSmall)
                .weight(1f)
        ) {
            content()
        }
        endIcon?.let {
            Icon(
                imageVector = endIcon,
                options = IconOptions(
                    description = null,
                    size = iconSize,
                    color = iconColor
                )
            )
        }
    }
}
