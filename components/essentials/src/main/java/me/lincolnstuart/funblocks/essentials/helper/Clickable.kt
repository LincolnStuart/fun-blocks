package me.lincolnstuart.funblocks.essentials.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.color.alpha.FunBlocksAlpha
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Generic surface clickable to provide another components based on it. E.g Button, Chip, etc.
 *
 * @param description text description.
 * @param onClick callback that executes when click is performed.
 * @param backgroundColor [FunBlocksColors].
 * @param borderColor [FunBlocksColors].
 * @param contentColor [FunBlocksColors] of text and icons.
 * @param shape it is recommended to use [FunBlocksCornerRadius].
 * @param isEnabled if the clickable area could perform a click.
 * @param startIcon [ImageVector] that will be showed at the start of this component.
 * @param endIcon [ImageVector] that will be showed at the end of this component.
 * @param iconSize [IconSize].
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param modifier optional [Modifier].
 */
@Composable
fun Clickable(
    description: String,
    onClick: (() -> Unit),
    backgroundColor: FunBlocksColors,
    borderColor: FunBlocksColors,
    contentColor: FunBlocksColors,
    shape: Shape,
    isEnabled: Boolean,
    startIcon: ImageVector?,
    endIcon: ImageVector?,
    iconSize: IconSize,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    val alpha = remember(isEnabled) {
        if (isEnabled) FunBlocksAlpha.visible else FunBlocksAlpha.medium
    }
    SimpleItem(
        content = {
            Text(
                text = description,
                modifier = Modifier
                    .padding(horizontal = FunBlocksSpacing.xxxSmall)
                    .align(Alignment.Center),
                mode = TextMode.Regular(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = contentColor
            )
        },
        modifier = modifier
            .clip(shape)
            .background(backgroundColor.value())
            .alpha(alpha)
            .border(
                width = FunBlocksBorderWidth.tiny,
                color = borderColor.value(),
                shape = shape
            )
            .clickable { if (isEnabled) onClick() }
            .padding(paddingValues),
        startIcon = startIcon,
        endIcon = endIcon,
        iconColor = contentColor,
        iconSize = iconSize
    )
}
