package me.lincolnstuart.funblocks.core.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.TablerIcons
import compose.icons.tablericons.Calendar
import me.lincolnstuart.funblocks.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme

/**
 * Basic icon based on [Image].
 *
 * @param imageVector [ImageVector] icon.
 * @param options icon customization.
 * @param modifier optional [Modifier].
 */
@Composable
public fun Icon(
    imageVector: ImageVector,
    options: IconOptions,
    modifier: Modifier = Modifier
) = with(options) {
    Image(
        imageVector = imageVector,
        contentDescription = description,
        modifier = modifier.size(size.dimension),
        colorFilter = ColorFilter.tint(color = color.value())
    )
}

@Preview
@Composable
private fun IconPreview() {
    FunBlocksTheme {
        Surface {
            Icon(
                imageVector = TablerIcons.Calendar,
                options = IconOptions(
                    description = "Description",
                    size = IconSize.Extra
                )
            )
        }
    }
}
