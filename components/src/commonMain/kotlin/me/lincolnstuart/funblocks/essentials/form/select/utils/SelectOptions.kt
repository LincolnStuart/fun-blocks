package me.lincolnstuart.funblocks.essentials.form.select.utils

import me.lincolnstuart.funblocks.essentials.form.select.BasicSelect

/**
 * Data class that customize a select component.
 *
 * @param label input label.
 * @param selectedItem [String] that represents what item was selected.
 * @param placeholder a clue to fill the input.
 * @param expandOptionDescription a description to arrow down icon.
 * @param counter number of items selected.
 * @param enabled controls the enabled state of the [BasicSelect]. When `false`, the text
 * field will be neither editable nor focusable, the input of the text field will not be selectable
 * @param readOnly controls the editable state of the [BasicSelect]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param error associated message.
 */
public data class SelectOptions(
    val label: String?,
    val selectedItem: String,
    val placeholder: String?,
    val expandOptionDescription: String?,
    val counter: Int?,
    val enabled: Boolean = true,
    val readOnly: Boolean = false,
    val error: String?
)
