package me.lincolnstuart.funblocks.essentials.core.helper.clickable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.essentials.core.helper.SimpleItem
import me.lincolnstuart.funblocks.essentials.core.helper.clickable.utils.ClickableOptions
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.color.alpha.FunBlocksAlpha
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Generic surface clickable to provide another components based on it. E.g Button, Chip, etc.
 *
 * @param description text description.
 * @param onClick callback that executes when click is performed.
 * @param options customized options.
 * @param isEnabled if the clickable area could perform a click.
 * @param startIcon [ImageVector] that will be showed at the start of this component.
 * @param endIcon [ImageVector] that will be showed at the end of this component.
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param modifier optional [Modifier].
 */
@Composable
fun Clickable(
    description: String,
    onClick: (() -> Unit),
    options: ClickableOptions,
    isEnabled: Boolean,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null
) = with(options) {
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
            .height(height ?: Dp.Unspecified)
            .padding(paddingValues),

        startIcon = startIcon,
        endIcon = endIcon,
        iconColor = contentColor,
        iconSize = iconSize
    )
}
