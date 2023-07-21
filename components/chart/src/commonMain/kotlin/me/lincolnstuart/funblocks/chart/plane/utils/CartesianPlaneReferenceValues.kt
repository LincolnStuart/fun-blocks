package me.lincolnstuart.funblocks.chart.plane.utils

/**
 * Data class that represents relevant marks to draw in the cartesian plane.
 *
 * @param verticalValues all vertical relevant points.
 * @param horizontalValues all horizontal relevant points.
 */
data class CartesianPlaneReferenceValues<V, H>(
    val verticalValues: List<V>,
    val horizontalValues: List<H>
)
