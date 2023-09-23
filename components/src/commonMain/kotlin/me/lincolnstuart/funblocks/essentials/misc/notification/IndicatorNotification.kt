package me.lincolnstuart.funblocks.essentials.misc.notification

import androidx.compose.foundation.background
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
import me.lincolnstuart.funblocks.essentials.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarMode
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Component that indicates whether there is any notification.
 *
 * @param content the content inside.
 */
@Composable
public fun IndicatorNotification(
    hasNotification: Boolean,
    content: @Composable () -> Unit
) {
    BasicNotification(
        displacement = PaddingValues(),
        content = content
    ) {
        if (hasNotification) {
            Box(
                modifier = Modifier
                    .size(FunBlocksSpacing.small)
                    .padding(FunBlocksSpacing.micro)
                    .clip(CircleShape)
                    .background(FunBlocksColors.Notification.value())
            )
        }
    }
}

// @Preview
@Composable
private fun NotificationIndicatorPreview() {
    FunBlocksTheme {
        Column(
            Modifier
                .background(color = Color.White)
                .padding(FunBlocksSpacing.small)
        ) {
            Row {
                IndicatorNotification(hasNotification = true) {
                    Avatar(
                        mode = AvatarMode.Initials(
                            fullName = "Lincoln Stuart"
                        ),
                        options = AvatarOptions(
                            shape = AvatarShape.Square
                        )
                    ) {}
                }
                HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                IndicatorNotification(hasNotification = true) {
                    Avatar(
                        mode = AvatarMode.Initials(
                            fullName = "Lincoln Stuart"
                        )
                    ) {}
                }
            }
            VerticalSpacer(height = FunBlocksSpacing.small)
            Row {
                IndicatorNotification(hasNotification = true) {
                    Avatar(
                        mode = AvatarMode.Initials(
                            fullName = "Lincoln Stuart"
                        ),
                        options = AvatarOptions(
                            size = AvatarSize.Large
                        )
                    ) {}
                }
                HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                IndicatorNotification(hasNotification = true) {
                    Avatar(
                        mode = AvatarMode.Initials(
                            fullName = "Lincoln Stuart"
                        ),
                        options = AvatarOptions(
                            shape = AvatarShape.Square,
                            size = AvatarSize.Large
                        )
                    ) {}
                }
            }
        }
    }
}
