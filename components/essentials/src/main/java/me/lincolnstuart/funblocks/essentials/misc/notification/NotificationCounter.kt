package me.lincolnstuart.funblocks.essentials.misc.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.misc.avatar.InitialsAvatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.essentials.misc.notification.utils.Counter
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Component that indicates the number of notifications.
 *
 * @param number number of notifications.
 * @param content the content inside.
 */
@Composable
public fun NotificationCounter(
    number: Int,
    content: @Composable () -> Unit
) {
    val formattedNumber = remember(number) {
        when {
            number <= 0 -> null
            number < 9 -> number.toString()
            else -> "+9"
        }
    }
    BasicNotification(
        displacement = PaddingValues(end = FunBlocksSpacing.xxxSmall),
        content = content
    ) {
        formattedNumber?.let {
            Counter(
                formattedNumber = formattedNumber,
                borderWidth = FunBlocksBorderWidth.large
            )
        }
    }
}

@Preview
@Composable
private fun NotificationCounterPreview() {
    FunBlocksTheme {
        Surface {
            Column(
                Modifier.padding(FunBlocksSpacing.small)
            ) {
                Row {
                    NotificationCounter(number = 5) {
                        InitialsAvatar(
                            fullName = "Lincoln Stuart",
                            options = AvatarOptions(
                                shape = AvatarShape.Square
                            )
                        )
                    }
                    HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                    NotificationCounter(number = -99) {
                        InitialsAvatar(fullName = "Lincoln Stuart")
                    }
                    HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                    NotificationCounter(number = 200) {
                        InitialsAvatar(fullName = "Lincoln Stuart")
                    }
                }
                VerticalSpacer(height = FunBlocksSpacing.small)
                Row {
                    NotificationCounter(number = 200) {
                        InitialsAvatar(
                            fullName = "Lincoln Stuart",
                            options = AvatarOptions(
                                size = AvatarSize.Large
                            )
                        )
                    }
                    HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
                    NotificationCounter(number = 200) {
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
}
