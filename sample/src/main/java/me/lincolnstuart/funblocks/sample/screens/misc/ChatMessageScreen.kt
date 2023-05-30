package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.chat.ChatMessage
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOptions
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOrientation
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

class ChatMessageScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ChatMessagePlaygroundOptions()
            }
        }
    }

    @Composable
    private fun ChatMessagePlaygroundOptions() {
        var options: ChatMessageOptions by remember {
            mutableStateOf(ChatMessageOptions(orientation = ChatMessageOrientation.Sent))
        }
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = FunBlocksColors.SurfaceMedium.value())
                    .padding(FunBlocksSpacing.small),
                contentAlignment = Alignment.Center
            ) {
                ChatMessage(
                    message = "Chat message",
                    options = options
                )
            }
            HorizontalDivider()
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
