package me.lincolnstuart.funblocks.essentials.form.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.TablerIcons
import compose.icons.tablericons.Check
import me.lincolnstuart.funblocks.core.icon.Icon
import me.lincolnstuart.funblocks.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Simple check box with an action associated.
 *
 * @param isSelected if it is selected.
 * @param onClick callback that executes when click is performed.
 */
@Composable
public fun CheckBox(
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
                shape = FunBlocksCornerRadius.small
            )
            .size(FunBlocksContentSize.xSmall)
            .clip(FunBlocksCornerRadius.small)
            .background(FunBlocksColors.SurfaceMedium.value())
            .clickable { onClick() }

    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .clip(FunBlocksCornerRadius.small)
                    .fillMaxSize()
                    .background(FunBlocksColors.Primary.value()),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = TablerIcons.Check,
                    options = IconOptions(
                        description = null,
                        size = IconSize.Tiny,
                        color = FunBlocksColors.Reversed
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun CheckboxPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.medium)) {
                CheckBox(isSelected = true) {}
                VerticalSpacer(height = FunBlocksSpacing.medium)
                CheckBox(isSelected = false) {}
            }
        }
    }
}
