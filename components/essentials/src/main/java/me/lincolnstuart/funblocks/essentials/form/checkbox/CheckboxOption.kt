package me.lincolnstuart.funblocks.essentials.form.checkbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Single option of a check box. Based on [CheckBox].
 *
 * @param option option.
 * @param selectedOptions list of options selected previously.
 * @param onSelect callback that executes when click is performed and returns the option selected.
 * @param modifier optional [Modifier].
 */
@Composable
public fun <T> CheckboxOption(
    option: T,
    selectedOptions: List<T>,
    onSelect: (T) -> Unit,
    modifier: Modifier = Modifier,
    optionDefinition: @Composable ColumnScope.(T) -> Unit
) {
    val isSelected = remember(option, selectedOptions) {
        selectedOptions.contains(option)
    }
    Row(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(1f)) {
            optionDefinition(option)
        }
        CheckBox(isSelected = isSelected) {
            onSelect(option)
        }
    }
}

@Preview
@Composable
private fun CheckboxOptionPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.medium)) {
                CheckboxOption(
                    option = "Option 1",
                    selectedOptions = listOf("Option 2"),
                    onSelect = {}
                ) {
                    Text(text = "Option 1")
                }
                VerticalSpacer(height = FunBlocksSpacing.medium)
                CheckboxOption(
                    option = "Option 2",
                    selectedOptions = listOf("Option 2"),
                    onSelect = {}
                ) {
                    Text(text = "Option 2")
                }
            }
        }
    }
}
