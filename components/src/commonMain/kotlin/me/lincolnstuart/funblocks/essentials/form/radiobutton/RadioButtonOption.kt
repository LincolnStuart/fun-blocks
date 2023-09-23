package me.lincolnstuart.funblocks.essentials.form.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.essentials.core.helper.SelectableItem
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Single option of a radio button. Based on [RadioButton].
 *
 * @param option option.
 * @param selectedOption option selected previously.
 * @param onSelect callback that executes when click is performed and returns the option selected.
 * @param modifier optional [Modifier].
 * @param optionDefinition composable responsible for draw the option component. It recommended to use
 * [SelectableItem]
 */
@Composable
public fun <T> RadioButtonOption(
    option: T,
    selectedOption: T?,
    onSelect: (T) -> Unit,
    modifier: Modifier = Modifier,
    optionDefinition: @Composable ColumnScope.(T) -> Unit
) {
    val isSelected = remember(option, selectedOption) {
        option == selectedOption
    }
    Row(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(1f)) {
            optionDefinition(option)
        }
        RadioButton(isSelected = isSelected) {
            onSelect(option)
        }
    }
}

// @Preview
@Composable
private fun RadioButtonOptionPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.medium)) {
                RadioButtonOption(
                    option = "Option 1",
                    selectedOption = "Option 2",
                    onSelect = {}
                ) {
                    Text(text = "Option 1")
                }
                VerticalSpacer(height = FunBlocksSpacing.medium)
                RadioButtonOption(
                    option = "Option 2",
                    selectedOption = "Option 2",
                    onSelect = {}
                ) {
                    Text(text = "Option 2")
                }
            }
        }
    }
}
