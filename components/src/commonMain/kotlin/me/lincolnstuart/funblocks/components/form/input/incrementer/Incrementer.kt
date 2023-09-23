package me.lincolnstuart.funblocks.components.form.input.incrementer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import compose.icons.TablerIcons
import compose.icons.tablericons.Minus
import compose.icons.tablericons.Plus
import compose.icons.tablericons.Trash
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.input.incrementer.utils.IncrementerOptions
import me.lincolnstuart.funblocks.components.form.utils.SmallInputSkeleton
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
public fun Incrementer(
    description: String,
    value: Int,
    options: IncrementerOptions = IncrementerOptions(),
    onValueChange: (Int) -> Unit
) = with(options) {
    val range = remember(minValue, maxValue) { minValue..maxValue }
    val plusColor = remember(value, maxValue) { getPlusColor(value) }
    val minusColor = remember(value, maxValue) { getMinusColor(value) }
    val resetColor = remember(value, isResetAllowed, minValue) { getResetColor(value) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = spacedBy(FunBlocksSpacing.xxSmall)
    ) {
        Text(text = description, modifier = Modifier.weight(1f), mode = TextMode.Subtitle())
        Icon(
            imageVector = TablerIcons.Plus,
            options = IconOptions(
                description = null,
                size = IconSize.Small,
                color = plusColor
            ),
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    val newValue = value + 1
                    if (newValue in range) onValueChange(newValue)
                }
        )
        SmallInputSkeleton(text = value.toString(), hasError = false)
        Icon(
            imageVector = TablerIcons.Minus,
            options = IconOptions(
                description = null,
                size = IconSize.Small,
                color = minusColor
            ),
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    val newValue = value - 1
                    if (newValue in range) onValueChange(newValue)
                }
        )
        if (isResetAllowed) {
            Icon(
                imageVector = TablerIcons.Trash,
                options = IconOptions(
                    description = null,
                    size = IconSize.Small,
                    color = resetColor
                ),
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onValueChange(minValue) }
            )
        }
    }
}

private fun IncrementerOptions.getResetColor(
    value: Int
) = if (value == minValue) {
    FunBlocksColors.NeutralLight
} else {
    FunBlocksColors.Negative
}

private fun IncrementerOptions.getMinusColor(
    value: Int
) = if (value > minValue) {
    FunBlocksColors.NeutralDark
} else {
    FunBlocksColors.NeutralLight
}

private fun IncrementerOptions.getPlusColor(value: Int) = if (value < maxValue) {
    FunBlocksColors.NeutralDark
} else {
    FunBlocksColors.NeutralLight
}

// @Preview
@Composable
private fun IncrementerPreview() {
    FunBlocksTheme {
        Surface {
            Column(
                modifier = Modifier.padding(all = FunBlocksSpacing.small),
                verticalArrangement = spacedBy(FunBlocksSpacing.xxSmall)
            ) {
                Incrementer(description = "Incrementer item", value = 5, onValueChange = {})
            }
        }
    }
}
