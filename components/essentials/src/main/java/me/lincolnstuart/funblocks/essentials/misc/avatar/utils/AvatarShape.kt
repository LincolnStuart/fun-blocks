package me.lincolnstuart.funblocks.essentials.misc.avatar.utils

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius

/**
 * Enum that provides avatar shape.
 *
 * @param shape it is recommended to use [FunBlocksCornerRadius] for square shapes.
 */
public enum class AvatarShape(val shape: RoundedCornerShape) {
    Circle(shape = CircleShape),
    Square(shape = FunBlocksCornerRadius.huge)
}
