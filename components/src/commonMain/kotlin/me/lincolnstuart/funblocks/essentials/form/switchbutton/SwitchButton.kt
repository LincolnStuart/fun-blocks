package me.lincolnstuart.funblocks.essentials.form.switchbutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Switch button that shows/interact with an boolean state.
 *
 * @param isOn if switch is on.
 * @param onClick callback that executes when click is performed and returns the the new switch state.
 */
@Composable
public fun SwitchButton(
    isOn: Boolean,
    onClick: (isOn: Boolean) -> Unit
) {
    val (backgroundColor, borderColor, alignment) = remember(isOn) {
        if (isOn) {
            Triple(FunBlocksColors.Primary, FunBlocksColors.PrimaryDark, Alignment.CenterEnd)
        } else {
            Triple(FunBlocksColors.SurfaceDark, FunBlocksColors.Border, Alignment.CenterStart)
        }
    }
    Box(
        modifier = Modifier
            .clip(FunBlocksCornerRadius.full)
            .height(FunBlocksContentSize.small)
            .width(FunBlocksContentSize.large)
            .clickable { onClick(!isOn) }
            .background(color = backgroundColor.value())
            .border(
                border = BorderStroke(
                    width = FunBlocksBorderWidth.tiny,
                    color = borderColor.value()
                ),
                shape = FunBlocksCornerRadius.full
            )
            .padding(FunBlocksSpacing.xxxSmall),
        contentAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .height(FunBlocksContentSize.xxSmall)
                .width(FunBlocksContentSize.xxSmall)
                .clip(CircleShape)
                .background(FunBlocksColors.Surface.value())
        )
    }
}

// @Preview
@Composable
private fun SwitchButtonPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                SwitchButton(isOn = true) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                SwitchButton(isOn = false) {}
            }
        }
    }
}
