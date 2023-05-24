package me.lincolnstuart.funblocks.essentials.misc.chip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.TablerIcons
import compose.icons.tablericons.Calendar
import compose.icons.tablericons.ChevronDown
import compose.icons.tablericons.X
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.helper.Clickable
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Clickable area based on [Clickable].
 *
 * @param description text description.
 * @param onClick callback that executes when click is performed.
 * @param isEnabled if the clickable area could perform a click.
 * @param isSelected if this chip is previously selected.
 * @param startIcon [ImageVector] that will be showed at the start of this component.
 * @param endIcon [ImageVector] that will be showed at the end of this component.
 */
@Composable
public fun Chip(
    description: String,
    isEnabled: Boolean = true,
    isSelected: Boolean = false,
    startIcon: ImageVector? = null,
    endIcon: ImageVector? = null,
    onClick: (() -> Unit)
) {
    val (backgroundColor, contentColor) = remember(isSelected) {
        if (isSelected) {
            FunBlocksColors.Primary to FunBlocksColors.Reversed
        } else {
            FunBlocksColors.Surface to FunBlocksColors.Primary
        }
    }
    Clickable(
        description = description,
        onClick = onClick,
        backgroundColor = backgroundColor,
        borderColor = FunBlocksColors.Primary,
        contentColor = contentColor,
        shape = FunBlocksCornerRadius.full,
        isEnabled = isEnabled,
        startIcon = startIcon,
        endIcon = endIcon,
        iconSize = IconSize.Tiny,
        paddingValues = FunBlocksInset.small,
        modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max)
    )
}

@Preview
@Composable
private fun ChipPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                Chip(
                    description = "Just a chip",
                    onClick = {}
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Chip(
                    description = "Disabled chip",
                    onClick = {},
                    isEnabled = false
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Chip(
                    description = "Selected chip",
                    onClick = {},
                    isSelected = true
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Chip(
                    description = "Chip with start icon",
                    onClick = {},
                    startIcon = TablerIcons.Calendar
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Chip(
                    description = "Chip with end icon",
                    onClick = {},
                    endIcon = TablerIcons.X
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Chip(
                    description = "Chip with start and end icon",
                    onClick = {},
                    startIcon = TablerIcons.Calendar,
                    endIcon = TablerIcons.ChevronDown
                )
            }
        }
    }
}
