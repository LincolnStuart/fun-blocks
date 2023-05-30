package me.lincolnstuart.funblocks.essentials.misc.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarMode
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Avatar base with shape and size applied. It can used in three different ways: [AvatarMode.Icon],
 * [AvatarMode.Image] and [AvatarMode.Initials].
 *
 * @param options [AvatarOptions].
 * @param modifier optional [Modifier].
 * @param mode [AvatarMode] that defines the content inside.
 */
@Composable
public fun Avatar(
    modifier: Modifier = Modifier,
    mode: AvatarMode = AvatarMode.Icon(),
    options: AvatarOptions = AvatarOptions()
) = with(options) {
    Box(
        modifier = modifier
            .size(size.size)
            .clip(shape.shape)
            .background(
                Brush.linearGradient(
                    listOf(
                        FunBlocksColors.PrimaryDark.value(),
                        FunBlocksColors.PrimaryLight.value()
                    )
                )
            )
    ) {
        mode.Content(options)
    }
}

@Preview
@Composable
private fun IconAvatarPreview() {
    FunBlocksTheme {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Avatar(
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Regular
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall)
                )
                Avatar(
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Large
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Avatar(
                    mode = AvatarMode.Initials(
                        fullName = "Lincoln Some Middle Name Stuart"
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Regular
                    )
                )
                Avatar(
                    mode = AvatarMode.Initials(
                        fullName = "Lincoln"
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Large
                    )
                )
            }
        }
    }
}
