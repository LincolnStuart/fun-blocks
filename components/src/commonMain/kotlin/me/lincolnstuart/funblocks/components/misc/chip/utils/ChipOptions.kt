package me.lincolnstuart.funblocks.components.misc.chip.utils

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data class that customize a chip.
 *
 * @param isEnabled if the clickable area could perform a click.
 * @param isSelected if this chip is previously selected.
 * @param startIcon [ImageVector] that will be showed at the start of this component.
 * @param endIcon [ImageVector] that will be showed at the end of this component.
 */
data class ChipOptions(
    val isEnabled: Boolean = true,
    val isSelected: Boolean = false,
    val startIcon: ImageVector? = null,
    val endIcon: ImageVector? = null
)
