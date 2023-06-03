package me.lincolnstuart.funblocks.essentials.form.button.group.utils

import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonOptions

/**
 * Data class that represents a button in a group.
 *
 * @param description text that describes the button action.
 * @param options [ButtonOptions] to customize button properties.
 * @param onClick callback that executes when click is performed.
 */
public data class ButtonOfGroupOptions(
    val description: String,
    val options: ButtonOptions = ButtonOptions(),
    val onClick: (() -> Unit)
)
