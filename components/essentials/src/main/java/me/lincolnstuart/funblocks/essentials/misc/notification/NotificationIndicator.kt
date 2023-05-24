package me.lincolnstuart.funblocks.essentials.misc.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.misc.avatar.InitialsAvatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Component that indicates whether there is any notification.
 *
 * @param content the content inside.
 */
@Composable
public fun NotificationIndicator(
    content: @Composable () -> Unit
) {
    BasicNotification(
        displacement = PaddingValues(),
        content = content
    ) {
        Box(
            modifier = Modifier
                .size(FunBlocksSpacing.small)
                .border(
                    width = FunBlocksBorderWidth.large,
                    color = FunBlocksColors.Surface.value(),
                    shape = CircleShape
                )
                .padding(FunBlocksSpacing.micro)
                .clip(CircleShape)
                .background(FunBlocksColors.Primary.value())
        )
    }
}

@Preview
@Composable
private fun NotificationIndicatorPreview() {
    FunBlocksTheme {
        Column(
            Modifier
                .background(color = Color.White)
                .padding(FunBlocksSpacing.small)
        ) {
            Row {
                NotificationIndicator {
                    InitialsAvatar(
                        fullName = "Lincoln Stuart",
                        options = AvatarOptions(
                            shape = AvatarShape.Square
                        )
                    )
                }
                HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                NotificationIndicator {
                    InitialsAvatar(fullName = "Lincoln Stuart")
                }
            }
            VerticalSpacer(height = FunBlocksSpacing.small)
            Row {
                NotificationIndicator {
                    InitialsAvatar(
                        fullName = "Lincoln Stuart",
                        options = AvatarOptions(
                            size = AvatarSize.Large
                        )
                    )
                }
                HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                NotificationIndicator {
                    InitialsAvatar(
                        fullName = "Lincoln Stuart",
                        options = AvatarOptions(
                            shape = AvatarShape.Square,
                            size = AvatarSize.Large
                        )
                    )
                }
            }
        }
    }
}
