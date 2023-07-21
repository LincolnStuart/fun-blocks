package me.lincolnstuart.funblocks.essentials.misc.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOptions
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOrientation
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * A message that organize your chat based on [ChatMessageOrientation].
 *
 * @param message text that was sent or received.
 * @param options [ChatMessageOptions] that defines orientation and avatar.
 */
@Composable
fun ChatMessage(
    message: String,
    options: ChatMessageOptions = ChatMessageOptions(),
    avatar: (@Composable () -> Unit)? = null
) = with(options) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = orientation.alignment
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (orientation == ChatMessageOrientation.Sent) avatar?.invoke()
            Box(
                Modifier
                    .padding(horizontal = FunBlocksSpacing.xxxSmall)
                    .clip(orientation.shape)
                    .background(orientation.color.value())
                    .padding(FunBlocksInset.medium)
            ) {
                Text(text = message, color = FunBlocksColors.PrimaryContrast)
            }
            if (orientation == ChatMessageOrientation.Received) avatar?.invoke()
        }
    }
}

@Preview
@Composable
private fun ChatMessagePreview() {
    FunBlocksTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(FunBlocksSpacing.small)
            ) {
                ChatMessage(
                    message = "My message.",
                    options = ChatMessageOptions(
                        orientation = ChatMessageOrientation.Sent
                    ),
                    avatar = { Avatar(options = AvatarOptions(size = AvatarSize.Small)) {} }
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                ChatMessage(
                    message = "Others message.",
                    options = ChatMessageOptions(
                        orientation = ChatMessageOrientation.Received
                    ),
                    avatar = { Avatar(options = AvatarOptions(size = AvatarSize.Small)) {} }
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                ChatMessage(
                    message = "New message.",
                    options = ChatMessageOptions(
                        orientation = ChatMessageOrientation.Sent
                    ),
                    avatar = { Avatar(options = AvatarOptions(size = AvatarSize.Small)) {} }
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                ChatMessage(
                    message = "Longer message (trying to fill max width and break one line).",
                    options = ChatMessageOptions(
                        orientation = ChatMessageOrientation.Sent
                    ),
                    avatar = { Avatar(options = AvatarOptions(size = AvatarSize.Small)) {} }
                )
            }
        }
    }
}
