package me.lincolnstuart.funblocks.essentials.form.input.pin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.core.text.utils.topic.TopicSize
import me.lincolnstuart.funblocks.essentials.form.utils.Error
import me.lincolnstuart.funblocks.essentials.form.utils.SmallInputSkeleton
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
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
                            SmallInputSkeleton(text = character, hasError = hasError)
                        }
                        repeat(size - sanitizedValue.length) {
                            SmallInputSkeleton(text = "", hasError = hasError)
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
