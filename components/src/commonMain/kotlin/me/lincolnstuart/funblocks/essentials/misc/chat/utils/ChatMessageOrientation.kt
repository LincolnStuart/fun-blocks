package me.lincolnstuart.funblocks.essentials.misc.chat.utils

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius

/**
 * Enum that provides the message orientation properties.
 *
 * @param shape message balloon shape.
 * @param color balloon color.
 * @param alignment horizontal alignment.
 */
public enum class ChatMessageOrientation(
    val shape: RoundedCornerShape,
    val color: FunBlocksColors,
    val alignment: Alignment
) {
    Sent(
        shape = FunBlocksCornerRadius.enormous.copy(bottomStart = CornerSize(2.dp)),
        color = FunBlocksColors.PrimaryLight,
        alignment = Alignment.CenterStart
    ),
    Received(
        shape = FunBlocksCornerRadius.enormous.copy(bottomEnd = CornerSize(2.dp)),
        color = FunBlocksColors.Secondary,
        alignment = Alignment.CenterEnd
    )
}
