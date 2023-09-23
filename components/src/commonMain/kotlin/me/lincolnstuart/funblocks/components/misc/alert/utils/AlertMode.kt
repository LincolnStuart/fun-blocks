package me.lincolnstuart.funblocks.components.misc.alert.utils

import androidx.compose.ui.graphics.vector.ImageVector
import compose.icons.TablerIcons
import compose.icons.tablericons.AlertCircle
import compose.icons.tablericons.CircleCheck
import compose.icons.tablericons.CircleX
import compose.icons.tablericons.InfoCircle
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Enum that provides the styled alert option.
 *
 * @param icon that represents the alert type.
 * @param color used on borders and background.
 */
public enum class AlertMode(
    val icon: ImageVector,
    val color: FunBlocksColors
) {
    Info(
        icon = TablerIcons.InfoCircle,
        color = FunBlocksColors.Info
    ),
    Warning(
        icon = TablerIcons.AlertCircle,
        color = FunBlocksColors.Warning
    ),
    Success(
        icon = TablerIcons.CircleCheck,
        color = FunBlocksColors.Positive
    ),
    Error(
        icon = TablerIcons.CircleX,
        color = FunBlocksColors.Negative
    )
}
