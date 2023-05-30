package me.lincolnstuart.funblocks.essentials.misc.chat.utils

/**
 * Data class that customizes a message.
 *
 * @param orientation if message is yours or from others.
 */
public data class ChatMessageOptions(
    val orientation: ChatMessageOrientation = ChatMessageOrientation.Sent
)
