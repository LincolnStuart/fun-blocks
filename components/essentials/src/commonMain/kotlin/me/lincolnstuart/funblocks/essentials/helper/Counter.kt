package me.lincolnstuart.funblocks.essentials.helper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontWeight

@Composable
internal fun Counter(
    formattedNumber: String,
    modifier: Modifier = Modifier,
    backgroundColor: FunBlocksColors = FunBlocksColors.Notification,
    fontColor: FunBlocksColors = FunBlocksColors.Reversed
) {
    Box(
        modifier = modifier
            .size(FunBlocksSpacing.medium)
            .padding(FunBlocksSpacing.micro)
            .clip(CircleShape)
            .background(backgroundColor.value())
    ) {
        Text(
            text = formattedNumber,
            modifier = Modifier.align(Alignment.Center),
            mode = TextMode.Custom(
                fontSize = FunBlocksFontSize.small,
                fontWeight = FunBlocksFontWeight.bold
            ),
            color = fontColor
        )
    }
}
