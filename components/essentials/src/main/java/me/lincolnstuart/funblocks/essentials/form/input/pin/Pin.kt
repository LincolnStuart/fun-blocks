package me.lincolnstuart.funblocks.essentials.form.input.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.core.text.utils.topic.TopicSize
import me.lincolnstuart.funblocks.essentials.form.utils.Error
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic pin component, based on [BasicTextField].
 *
 * @param value the input [String] text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param label input label.
 * @param error associated message.
 * @param isCharactersHide if hide input characters.
 * @param size number of characters.
 */
@Composable
public fun Pin(
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    error: String? = null,
    isCharactersHide: Boolean = false,
    size: Int = 5
) {
    Row {
        Column(modifier = Modifier.weight(1f)) {
            label?.let {
                Text(
                    text = label,
                    mode = TextMode.Topic(size = TopicSize.Small)
                )
            }
            val sanitizedValue = remember(value) {
                sanitizeValue(value = value, size = size)
            }
            val hasError = remember(error) {
                error != null
            }
            BasicTextField(
                value = sanitizedValue,
                onValueChange = { newValue ->
                    onValueChange(sanitizeValue(value = newValue, size = size))
                },
                modifier = Modifier.padding(vertical = FunBlocksSpacing.xxSmall),
                decorationBox = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        sanitizedValue.forEach { char ->
                            val character = if (isCharactersHide) "•" else char.toString()
                            CharacterBox(text = character, hasError = hasError)
                        }
                        repeat(size - sanitizedValue.length) { index ->
                            CharacterBox(text = "", hasError = hasError)
                        }
                    }
                }
            )
            error?.let { Error(message = error) }
        }
    }
}

private fun sanitizeValue(
    value: String,
    size: Int
): String =
    if (value.length >= size) {
        value.substring(0 until size)
    } else {
        value
    }

@Composable
private fun CharacterBox(
    text: String,
    hasError: Boolean
) {
    val boxColor = remember(hasError) {
        if (hasError) FunBlocksColors.Negative else FunBlocksColors.Border
    }
    Box(
        modifier = Modifier
            .size(
                width = FunBlocksContentSize.xLarge,
                height = FunBlocksContentSize.xxLarge
            )
            .background(
                color = FunBlocksColors.Surface.value(),
                shape = FunBlocksCornerRadius.medium
            )
            .border(
                width = FunBlocksBorderWidth.tiny,
                color = boxColor.value(),
                shape = FunBlocksCornerRadius.medium
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun PinPreview() {
    FunBlocksTheme {
        Surface {
            Column(verticalArrangement = spacedBy(FunBlocksSpacing.xxSmall)) {
                Pin(value = "123", onValueChange = {})
                Pin(value = "123", onValueChange = {}, isCharactersHide = true)
                Pin(value = "", onValueChange = {})
                Pin(value = "1", onValueChange = {}, size = 3)
                Pin(value = "123", onValueChange = {}, label = "Pin")
                Pin(value = "123", onValueChange = {}, label = "Pin", error = "Pin error")
            }
        }
    }
}
