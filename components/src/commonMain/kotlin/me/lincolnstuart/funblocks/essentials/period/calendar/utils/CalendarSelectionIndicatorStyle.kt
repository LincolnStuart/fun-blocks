package me.lincolnstuart.funblocks.essentials.period.calendar.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius

enum class CalendarSelectionIndicatorStyle(
    val shape: RoundedCornerShape,
    val backgroundColor: FunBlocksColors,
    val borderColor: FunBlocksColors
) {
    None(
        shape = FunBlocksCornerRadius.none,
        backgroundColor = FunBlocksColors.Transparent,
        borderColor = FunBlocksColors.Transparent
    ),
    Regular(
        shape = FunBlocksCornerRadius.medium,
        backgroundColor = FunBlocksColors.Primary,
        borderColor = FunBlocksColors.PrimaryDark
    ),
    Start(
        shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp),
        backgroundColor = FunBlocksColors.Primary,
        borderColor = FunBlocksColors.PrimaryDark
    ),
    End(
        shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp),
        backgroundColor = FunBlocksColors.Primary,
        borderColor = FunBlocksColors.PrimaryDark
    ),
    Between(
        shape = FunBlocksCornerRadius.none,
        backgroundColor = FunBlocksColors.PrimaryLight,
        borderColor = FunBlocksColors.PrimaryLight
    )
}
