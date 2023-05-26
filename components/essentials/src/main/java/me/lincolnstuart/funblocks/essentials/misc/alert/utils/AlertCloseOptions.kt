package me.lincolnstuart.funblocks.essentials.misc.alert.utils

/**
 * Data class that represents the close action on alert.
 *
 * @param closeDescription icon description.
 * @param onClose callback that executes when close click is performed.
 */
data class AlertCloseOptions(
    val closeDescription: String? = null,
    val onClose: (() -> Unit)? = null
)
