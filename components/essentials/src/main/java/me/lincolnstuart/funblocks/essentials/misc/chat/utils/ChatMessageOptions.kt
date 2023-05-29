package me.lincolnstuart.funblocks.essentials.misc.chat.utils

import androidx.compose.runtime.Composable
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar

/**
 * Data class that customizes a message.
 *
 * @param orientation if message is yours or from others.
 * @param avatar avatar that represents a person that sent the message. It could be any [Composable],
 * it is recommended to use [Avatar], tho.
 */
public data class ChatMessageOptions(
    val orientation: ChatMessageOrientation,
    val avatar: (@Composable () -> Unit)? = null

)
