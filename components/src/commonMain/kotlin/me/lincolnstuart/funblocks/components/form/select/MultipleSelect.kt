package me.lincolnstuart.funblocks.components.form.select

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.lincolnstuart.funblocks.components.core.helper.SelectableItem
import me.lincolnstuart.funblocks.components.core.helper.SimpleItem
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.form.button.group.utils.ButtonOfGroupOptions
import me.lincolnstuart.funblocks.components.form.checkbox.CheckboxGroup
import me.lincolnstuart.funblocks.components.form.popup.ActionPopup
import me.lincolnstuart.funblocks.components.form.select.utils.SelectOptions
import me.lincolnstuart.funblocks.components.form.utils.BasicInputSkeleton
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
 * @param enabled controls the enabled state of the [BasicSelect]. When `false`, the text
 * field will be neither editable nor focusable, the input of the text field will not be selectable
 * @param readOnly controls the editable state of the [BasicSelect]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param error associated message.
 */
@Composable
public fun <T> MultipleSelect(
    selectedValues: List<T>,
    mapToPresentation: (T) -> SelectableItem,
    onSelectValues: (List<T>) -> Unit,
    options: List<T>,
    paddingValues: PaddingValues = PaddingValues(),
    expandOptionDescription: String? = null,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    error: String? = null
) {
    var expanded by remember { mutableStateOf(false) }
    var popUpSelection by remember { mutableStateOf(selectedValues) }
    val selectedItems = rememberSelectedItems(
        selectedValues = selectedValues,
        mapToPresentation = mapToPresentation
    )
    BasicSelect(
        options = SelectOptions(
            label = label,
            selectedItem = selectedItems,
            placeholder = placeholder,
            expandOptionDescription = expandOptionDescription,
            counter = selectedValues.size,
            readOnly = readOnly,
            enabled = enabled,
            error = error
        ),
        paddingValues = paddingValues,
        onClick = { expanded = !expanded }
    ) {
        if (expanded && readOnly.not() && enabled) {
            ActionPopup(
                title = placeholder.orEmpty().ifEmpty { label.orEmpty() },
                onDismissRequest = { expanded = !expanded },
                primaryActionOptions = ButtonOfGroupOptions(
                    description = "Ok" // TODO put a param to this label
                ) {
                    onSelectValues(popUpSelection)
                    expanded = false
                }, // TODO put a param to this label
                secondaryActionOptions = ButtonOfGroupOptions(description = "Cancel") {
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
                                if (popUpSelection.contains(it)) remove(it) else add(it)
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

@Composable
private fun <T> rememberSelectedItems(
    selectedValues: List<T>,
    mapToPresentation: (T) -> SelectableItem
) = remember(selectedValues) {
    selectedValues.joinToString(", ") { selectedValue ->
        mapToPresentation(selectedValue).description
    }
}
