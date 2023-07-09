package me.lincolnstuart.funblocks.essentials.form.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleX
import me.lincolnstuart.funblocks.core.icon.Icon
import me.lincolnstuart.funblocks.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

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
    disabled: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    val boxColor = remember(error) {
        if (error == null) FunBlocksColors.Border else FunBlocksColors.Negative
    }
    val backgroundColor = remember(disabled) {
        if (disabled) FunBlocksColors.SurfaceDark else FunBlocksColors.Transparent
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
                    .background(color = backgroundColor.value())
                    .padding(FunBlocksInset.medium)
            ) {
                content()
            }
            error?.let { Error(message = error) }
        }
    }
}

@Composable
public fun Error(message: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = message, color = FunBlocksColors.Negative)
        HorizontalSpacer(width = FunBlocksSpacing.tiny)
        Icon(
            imageVector = TablerIcons.CircleX,
            options = IconOptions(
                size = IconSize.Tiny,
                description = null,
                color = FunBlocksColors.Negative
            )
        )
    }
}
