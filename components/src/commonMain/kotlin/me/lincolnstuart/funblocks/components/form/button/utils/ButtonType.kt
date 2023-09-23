package me.lincolnstuart.funblocks.components.form.button.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Enum that provides the button type.
 *
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param height it is recommended to use [FunBlocksContentSize].
 * @param shape it is recommended to use [FunBlocksCornerRadius] for square shapes.
 */
public enum class ButtonType(
    val paddingValues: PaddingValues,
    val height: Dp,
    val shape: Shape
) {
    Small(
        paddingValues = FunBlocksInset.medium,
        height = FunBlocksContentSize.large,
        shape = FunBlocksCornerRadius.small
    ),
    Regular(
        paddingValues = FunBlocksInset.large,
        height = FunBlocksContentSize.xxLarge,
        shape = FunBlocksCornerRadius.small
    )
}
