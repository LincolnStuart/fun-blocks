package me.lincolnstuart.funblocks.essentials.form.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.core.helper.SelectableItem
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Radio button group with all options. Based on [RadioButtonOption].
 *
 * @param options list of selectable options.
 * @param selectedOption option selected previously.
 * @param onSelectOption callback that executes when click is performed and returns the option selected.
 * @param modifier optional [Modifier].
 * @param optionDefinition composable responsible for draw the option component. It recommended to use
 * [SelectableItem]
 */
@Composable
public fun <T> RadioButtonGroup(
    options: List<T>,
    selectedOption: T?,
    onSelectOption: (T) -> Unit,
    modifier: Modifier = Modifier,
    optionDefinition: @Composable ColumnScope.(T) -> Unit
) {
    Column(modifier = modifier) {
        options.forEachIndexed { index, option ->
            RadioButtonOption(
                option = option,
                selectedOption = selectedOption,
                onSelect = onSelectOption,
                optionDefinition = optionDefinition,
                modifier = Modifier.padding(vertical = FunBlocksSpacing.small)
            )
            if (options.lastIndex != index) {
                HorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun RadioButtonGroupPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.medium)) {
                RadioButtonGroup(
                    options = listOf("Option 1", "Option 2", "Option 3"),
                    selectedOption = "Option 2",
                    onSelectOption = {}
                ) {
                    Text(text = it)
                }
            }
        }
    }
}
