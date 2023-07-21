package me.lincolnstuart.funblocks.essentials.form.radiobutton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Simple radio button with an action associated.
 *
 * @param isSelected if it is selected.
 * @param onClick callback that executes when click is performed.
 */
@Composable
public fun RadioButton(
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = remember(isSelected) {
        if (isSelected) FunBlocksColors.PrimaryDark else FunBlocksColors.Border
    }
    Box(
        modifier = Modifier
            .border(
                width = FunBlocksBorderWidth.tiny,
                color = borderColor.value(),
                shape = CircleShape
            )
            .size(FunBlocksContentSize.xSmall)
            .clip(CircleShape)
            .background(FunBlocksColors.SurfaceMedium.value())
            .clickable { onClick() }

    ) {
        if (isSelected) {
            val color = FunBlocksColors.Primary.value()
            Box(
                modifier = Modifier
                    .border(width = FunBlocksBorderWidth.tiny, color = color, shape = CircleShape)
                    .padding(FunBlocksSpacing.xxxSmall)
                    .clip(CircleShape)
                    .fillMaxSize()
                    .background(color = color)
            )
        }
    }
}

@Preview
@Composable
private fun RadioButtonPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.medium)) {
                RadioButton(isSelected = true) {}
                VerticalSpacer(height = FunBlocksSpacing.medium)
                RadioButton(isSelected = false) {}
            }
        }
    }
}
