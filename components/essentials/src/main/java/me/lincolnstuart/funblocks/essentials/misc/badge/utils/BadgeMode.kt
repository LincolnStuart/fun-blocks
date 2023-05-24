package me.lincolnstuart.funblocks.essentials.misc.badge.utils

import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Enum that provides the styled badge option.
 *
 * @param backgroundColor [FunBlocksColors].
 * @param contentColor [FunBlocksColors] used in icons and texts.
 */
public enum class BadgeMode(
    val backgroundColor: FunBlocksColors,
    val contentColor: FunBlocksColors
) {
    Info(
        backgroundColor = FunBlocksColors.Info,
        contentColor = FunBlocksColors.InfoDark
    ),
    Warning(
        backgroundColor = FunBlocksColors.Warning,
        contentColor = FunBlocksColors.WarningDark
    ),
    Success(
        backgroundColor = FunBlocksColors.Positive,
        contentColor = FunBlocksColors.PositiveDark
    ),
    Error(
        backgroundColor = FunBlocksColors.Negative,
        contentColor = FunBlocksColors.NegativeDark
    )
}
