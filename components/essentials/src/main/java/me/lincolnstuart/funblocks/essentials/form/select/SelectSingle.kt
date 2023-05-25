package me.lincolnstuart.funblocks.essentials.form.select

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonOptions
import me.lincolnstuart.funblocks.essentials.form.popup.ActionPopup
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.form.select.utils.SelectOptions
import me.lincolnstuart.funblocks.essentials.form.utils.BasicInputSkeleton
import me.lincolnstuart.funblocks.essentials.helper.SelectableItem
import me.lincolnstuart.funblocks.essentials.helper.SimpleItem
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Single select component. Based on [BasicInputSkeleton].
 *
 * @param selectedValue value previously selected.
 * @param mapToPresentation a map to [SelectableItem] to be represented as a list.
 * @param onSelectValue callback that executes when a selected item is confirmed.
 * @param options all options that could be selected.
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param expandOptionDescription a description to arrow down icon.
 * @param label input label.
 * @param placeholder a clue to fill the input.
 * @param error associated message.
 */
@Composable
public fun <T> SelectSingle(
    selectedValue: T?,
    mapToPresentation: (T) -> SelectableItem,
    onSelectValue: (T) -> Unit,
    options: List<T>,
    paddingValues: PaddingValues = PaddingValues(),
    expandOptionDescription: String? = null,
    label: String? = null,
    placeholder: String? = null,
    error: String? = null
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var popUpSelection by remember {
        mutableStateOf(selectedValue)
    }
    val selectedItem = remember(selectedValue) {
        selectedValue?.let { mapToPresentation(selectedValue).description }.orEmpty()
    }
    BasicSelect(
        options = SelectOptions(
            label = label,
            selectedItem = selectedItem,
            placeholder = placeholder,
            expandOptionDescription = expandOptionDescription,
            counter = null,
            error = error
        ),
        paddingValues = paddingValues,
        onClick = { expanded = !expanded }
    ) {
        if (expanded) {
            ActionPopup(
                title = placeholder.orEmpty(),
                onDismissRequest = { expanded = !expanded },
                primaryActionOptions = ButtonOptions(
                    description = "Ok",
                    isEnabled = popUpSelection != null
                ) {
                    onSelectValue(popUpSelection!!)
                    expanded = false
                },
                secondaryActionOptions = ButtonOptions(description = "Cancel") {
                    popUpSelection = selectedValue
                    expanded = false
                }
            ) {
                RadioButtonGroup(
                    options = options,
                    selectedOption = popUpSelection,
                    onSelectOption = { popUpSelection = it }
                ) { option ->
                    val presentation = mapToPresentation(option)
                    SimpleItem(startIcon = presentation.startIcon) {
                        Text(presentation.description)
                    }
                }
            }
        }
    }
}
