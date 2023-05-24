package me.lincolnstuart.funblocks.essentials.misc.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Avatar base with shape and size applied.
 *
 * @param options [AvatarOptions].
 * @param modifier optional [Modifier].
 * @param content the content inside.
 */
@Composable
internal fun BasicAvatar(
    options: AvatarOptions,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = with(options) {
    Box(
        modifier = modifier
            .size(size.size)
            .clip(shape.shape)
            .background(FunBlocksColors.SurfaceDark.value())
    ) {
        content()
    }
}
