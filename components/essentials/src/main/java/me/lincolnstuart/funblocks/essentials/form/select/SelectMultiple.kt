package me.lincolnstuart.funblocks.essentials.form.select

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonOptions
import me.lincolnstuart.funblocks.essentials.form.checkbox.CheckboxGroup
import me.lincolnstuart.funblocks.essentials.form.popup.ActionPopup
import me.lincolnstuart.funblocks.essentials.form.utils.BasicInputSkeleton
import me.lincolnstuart.funblocks.essentials.helper.SelectableItem
import me.lincolnstuart.funblocks.essentials.helper.SimpleItem
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Multiple select component. Based on [BasicInputSkeleton].
 *
 * @param selectedValues values previously selected.
 * @param mapToPresentation a map to [SelectableItem] to be represented as a list.
 * @param onSelectValues callback that executes when selected items are confirmed.
 * @param options all options that could be selected.
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param expandOptionDescription a description to arrow down icon.
 * @param label input label.
 * @param placeholder a clue to fill the input.
 * @param error associated message.
 */
@Composable
public fun <T> SelectMultiple(
    selectedValues: List<T>,
    mapToPresentation: (T) -> SelectableItem,
    onSelectValues: (List<T>) -> Unit,
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
        mutableStateOf(selectedValues)
    }
    val selectedItems = remember(selectedValues) {
        selectedValues.joinToString(", ") { selectedValue ->
            mapToPresentation(selectedValue).description
        }
    }
    BasicSelect(
        label = label,
        selectedItem = selectedItems,
        placeholder = placeholder,
        expandOptionDescription = expandOptionDescription,
        counter = selectedValues.size,
        error = error,
        paddingValues = paddingValues,
        onClick = { expanded = !expanded }
    ) {
        if (expanded) {
            ActionPopup(
                title = placeholder.orEmpty().ifEmpty { label.orEmpty() },
                onDismissRequest = { expanded = !expanded },
                primaryActionOptions = ButtonOptions(
                    description = "Ok" // TODO put a param to this label
                ) {
                    onSelectValues(popUpSelection)
                    expanded = false
                },
                secondaryActionOptions = ButtonOptions(description = "Cancel") { // TODO put a param to this label
                    popUpSelection = selectedValues
                    expanded = false
                }
            ) {
                CheckboxGroup(
                    options = options,
                    selectedOptions = popUpSelection,
                    onSelectOption = {
                        popUpSelection =
                            buildList {
                                addAll(popUpSelection)
                                if (popUpSelection.contains(it)) {
                                    remove(it)
                                } else {
                                    add(it)
                                }
                            }
                    }
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
