package me.lincolnstuart.funblocks.components.form.button.utils

import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Enum that provides the styled button option.
 *
 * @param backgroundColor [FunBlocksColors].
 * @param contentColor [FunBlocksColors] used in icons and texts.
 */
public enum class ButtonMode(
    val backgroundColor: FunBlocksColors,
    val contentColor: FunBlocksColors
) {
    Primary(
        backgroundColor = FunBlocksColors.Primary,
        contentColor = FunBlocksColors.PrimaryContrast
    ),
    Secondary(
        backgroundColor = FunBlocksColors.Secondary,
        contentColor = FunBlocksColors.Reversed
    ),
    Ghost(
        backgroundColor = FunBlocksColors.Transparent,
        contentColor = FunBlocksColors.NeutralDark
    ),
    Danger(
        backgroundColor = FunBlocksColors.Negative,
        contentColor = FunBlocksColors.Reversed
    )
}
