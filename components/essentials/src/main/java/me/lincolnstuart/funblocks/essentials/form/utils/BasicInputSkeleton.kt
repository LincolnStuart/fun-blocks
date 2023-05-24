package me.lincolnstuart.funblocks.essentials.form.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset

/**
 * Generic component responsible to draw an input skeleton.
 *
 * @param error associated message.
 * @param modifier optional [Modifier].
 * @param content the content inside.
 */
@Composable
internal fun BasicInputSkeleton(
    error: String?,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val boxColor = remember {
        if (error == null) FunBlocksColors.Border else FunBlocksColors.Negative
    }
    Row(modifier = modifier) {
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .clip(FunBlocksCornerRadius.medium)
                    .border(
                        width = FunBlocksBorderWidth.tiny,
                        color = boxColor.value(),
                        shape = FunBlocksCornerRadius.medium
                    )
                    .padding(FunBlocksInset.medium)
            ) {
                content()
            }
            error?.let {
                Text(text = error)
            }
        }
    }
}
