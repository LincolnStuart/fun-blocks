package me.lincolnstuart.funblocks.essentials.misc.alert.utils

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
 * @param darkColor used on icon alert.
 * @param color used on borders and background.
 */
public enum class AlertType(
    val icon: ImageVector,
    val darkColor: FunBlocksColors,
    val color: FunBlocksColors
) {
    Info(
        icon = TablerIcons.InfoCircle,
        darkColor = FunBlocksColors.InfoDark,
        color = FunBlocksColors.Info
    ),
    Warning(
        icon = TablerIcons.AlertCircle,
        darkColor = FunBlocksColors.WarningDark,
        color = FunBlocksColors.Warning
    ),
    Success(
        icon = TablerIcons.CircleCheck,
        darkColor = FunBlocksColors.PositiveDark,
        color = FunBlocksColors.Positive
    ),
    Error(
        icon = TablerIcons.CircleX,
        darkColor = FunBlocksColors.NegativeDark,
        color = FunBlocksColors.Negative
    )
}
