package me.lincolnstuart.funblocks.foundation.ui.token.content.shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/**
 * Object that provides corner radius tokens to standard surface components.
 *
 * Based on [androidx.compose.foundation.shape.RoundedCornerShape].
 */
public object FunBlocksCornerRadius {
    public val none: RoundedCornerShape = RoundedCornerShape(0.dp)
    public val small: RoundedCornerShape = RoundedCornerShape(2.dp)
    public val medium: RoundedCornerShape = RoundedCornerShape(4.dp)
    public val large: RoundedCornerShape = RoundedCornerShape(6.dp)
    public val huge: RoundedCornerShape = RoundedCornerShape(8.dp)
    public val enormous: RoundedCornerShape = RoundedCornerShape(12.dp)
    public val full: RoundedCornerShape = RoundedCornerShape(percent = 100)
}
