package me.lincolnstuart.funblocks.essentials.helper.clickable.utils

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Data class that customize a clickable area.
 *
 * @param backgroundColor [FunBlocksColors].
 * @param borderColor [FunBlocksColors].
 * @param contentColor [FunBlocksColors] of text and icons.
 * @param shape it is recommended to use [FunBlocksCornerRadius].
 * @param iconSize [IconSize].
 * @param height it is recommended to use [FunBlocksContentSize].
 */
public data class ClickableOptions(
    val backgroundColor: FunBlocksColors,
    val borderColor: FunBlocksColors,
    val contentColor: FunBlocksColors,
    val shape: Shape,
    val iconSize: IconSize,
    val height: Dp? = null
)
