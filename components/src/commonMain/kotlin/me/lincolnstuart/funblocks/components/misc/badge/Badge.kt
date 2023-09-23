package me.lincolnstuart.funblocks.components.misc.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.TablerIcons
import compose.icons.tablericons.AlertCircle
import compose.icons.tablericons.CircleCheck
import compose.icons.tablericons.CircleX
import compose.icons.tablericons.InfoCircle
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.misc.badge.utils.BadgeMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Status badge with description and an optional icon.
 *
 * @param description status description.
 * @param mode style [BadgeMode].
 * @param startIcon optional [ImageVector] that will be showed at the start of this component.
 */
@Composable
public fun Badge(
    description: String,
    mode: BadgeMode,
    startIcon: ImageVector? = null
) = with(mode) {
    Box(
        modifier = Modifier
            .clip(shape = FunBlocksCornerRadius.full)
            .background(backgroundColor.value())
    ) {
        Row(
            modifier = Modifier
                .padding(FunBlocksInset.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            startIcon?.let {
                Icon(
                    imageVector = startIcon,
                    options = IconOptions(
                        description = null,
                        size = IconSize.Tiny,
                        color = contentColor
                    )
                )
            }
            Text(
                text = description,
                modifier = Modifier.padding(horizontal = FunBlocksSpacing.xxxSmall),
                color = contentColor
            )
        }
    }
}

// @Preview
@Composable
private fun BadgePreview() {
    FunBlocksTheme {
        Column {
            Badge(
                description = "Info",
                mode = BadgeMode.Info
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Info",
                mode = BadgeMode.Info,
                startIcon = TablerIcons.InfoCircle
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Warning",
                mode = BadgeMode.Warning
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Warning",
                mode = BadgeMode.Warning,
                startIcon = TablerIcons.AlertCircle
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Success",
                mode = BadgeMode.Success
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Success",
                mode = BadgeMode.Success,
                startIcon = TablerIcons.CircleCheck
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Error",
                mode = BadgeMode.Error
            )
            VerticalSpacer(height = FunBlocksSpacing.small)
            Badge(
                description = "Error",
                mode = BadgeMode.Error,
                startIcon = TablerIcons.CircleX
            )
        }
    }
}
