package me.lincolnstuart.funblocks.essentials.form.button.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Shape
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Enum that provides the button type.
 *
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param shape it is recommended to use [FunBlocksCornerRadius] for square shapes.
 */
public enum class ButtonType(
    val paddingValues: PaddingValues,
    val shape: Shape
) {
    Small(paddingValues = FunBlocksInset.medium, shape = FunBlocksCornerRadius.small),
    Regular(paddingValues = FunBlocksInset.large, shape = FunBlocksCornerRadius.small)
}
