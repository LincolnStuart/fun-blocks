package me.lincolnstuart.funblocks.essentials.form.select.utils

/**
 * Data class that customize a select component.
 *
 * @param label input label.
 * @param selectedItem [String] that represents what item was selected.
 * @param placeholder a clue to fill the input.
 * @param expandOptionDescription a description to arrow down icon.
 * @param counter number of items selected.
 * @param error associated message.
 */
public data class SelectOptions(
    val label: String?,
    val selectedItem: String,
    val placeholder: String?,
    val expandOptionDescription: String?,
    val counter: Int?,
    val error: String?
)
