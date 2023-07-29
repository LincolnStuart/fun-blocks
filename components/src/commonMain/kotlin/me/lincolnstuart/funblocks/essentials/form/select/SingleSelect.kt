package me.lincolnstuart.funblocks.essentials.form.select

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.button.group.utils.ButtonOfGroupOptions
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
 * @param enabled controls the enabled state of the [BasicSelect]. When `false`, the text
 * field will be neither editable nor focusable, the input of the text field will not be selectable
 * @param readOnly controls the editable state of the [BasicSelect]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param error associated message.
 */
@Composable
public fun <T> SingleSelect(
    selectedValue: T?,
    mapToPresentation: (T) -> SelectableItem,
    onSelectValue: (T) -> Unit,
    options: List<T>,
    paddingValues: PaddingValues = PaddingValues(),
    expandOptionDescription: String? = null,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
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
            readOnly = readOnly,
            enabled = enabled,
            error = error
        ),
        paddingValues = paddingValues,
        onClick = { expanded = !expanded }
    ) {
        if (expanded && readOnly.not() && enabled) {
            ActionPopup(
                title = placeholder.orEmpty(),
                onDismissRequest = { expanded = !expanded },
                primaryActionOptions = ButtonOfGroupOptions(
                    description = "Ok",
                    options = ButtonOptions(isEnabled = popUpSelection != null)
                ) {
                    onSelectValue(popUpSelection!!)
                    expanded = false
                },
                secondaryActionOptions = ButtonOfGroupOptions(description = "Cancel") {
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
