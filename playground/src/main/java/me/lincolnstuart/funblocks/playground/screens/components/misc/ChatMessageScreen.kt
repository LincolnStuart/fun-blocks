package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.chat.ChatMessage
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOptions
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOrientation
import me.lincolnstuart.funblocks.playground.components.Sample

class ChatMessageScreen : Screen {

    @Composable
    override fun Content() {
        var options: ChatMessageOptions by remember {
            mutableStateOf(ChatMessageOptions(orientation = ChatMessageOrientation.Sent))
        }
        Sample(
            component = {
                ChatMessage(
                    message = "Chat message",
                    options = options
                )
            }
        ) {
            Accordion(title = "Orientation") {
                RadioButtonGroup(
                    options = listOf(
                        ChatMessageOrientation.Sent,
                        ChatMessageOrientation.Received
                    ),
                    selectedOption = options.orientation,
                    onSelectOption = { options = options.copy(orientation = it) }
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}
