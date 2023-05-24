package me.lincolnstuart.funblocks.essentials.form.button.utils

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data class that customize button options.
 *
 * @param description text that describes the button action.
 * @param onClick callback that executes when click is performed.
 * @param mode [ButtonMode] style.
 * @param type [ButtonType].
 * @param isEnabled if the button is clickable.
 * @param startIcon optional [ImageVector] that will be showed at the button start.
 * @param endIcon optional [ImageVector] that will be showed at the button end.
 */
public data class ButtonOptions(
    val description: String,
    val mode: ButtonMode = ButtonMode.Primary,
    val type: ButtonType = ButtonType.Regular,
    val isEnabled: Boolean = true,
    val startIcon: ImageVector? = null,
    val endIcon: ImageVector? = null,
    val onClick: (() -> Unit)
)
