package me.lincolnstuart.funblocks.essentials.misc.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.core.helper.Counter
import me.lincolnstuart.funblocks.essentials.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarMode
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

private const val MIN_COUNTER: Int = 1
private const val MAX_COUNTER: Int = 9

/**
 * Component that indicates the number of notifications.
 *
 * @param number number of notifications.
 * @param content the content inside.
 */
@Composable
public fun CounterNotification(
    number: Int,
    content: @Composable () -> Unit
) {
    val formattedNumber = remember(number) {
        when {
            number < MIN_COUNTER -> null
            number < MAX_COUNTER -> number.toString()
            else -> "+9"
        }
    }
    BasicNotification(
        displacement = PaddingValues(end = FunBlocksSpacing.xxxSmall),
        content = content
    ) {
        formattedNumber?.let {
            Counter(formattedNumber = formattedNumber)
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
                    CounterNotification(number = 5) {
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
                    CounterNotification(number = -99) {
                        Avatar(
                            mode = AvatarMode.Initials(
                                fullName = "Lincoln Stuart"
                            )
                        ) {}
                    }
                }
                VerticalSpacer(height = FunBlocksSpacing.small)
                Row {
                    CounterNotification(number = 200) {
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
                    CounterNotification(number = 200) {
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
}
