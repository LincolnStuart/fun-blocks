package me.lincolnstuart.funblocks.essentials.core.helper

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data class responsible to customize an selectable item.
 *
 * @param description item description.
 * @param startIcon optional [ImageVector] that will be showed at the start of this component.
 */
public data class SelectableItem(
    val description: String,
    val startIcon: ImageVector? = null
)
