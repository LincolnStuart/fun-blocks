package me.lincolnstuart.funblocks.essentials.form.input

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme

/**
 * Text area component, based on [Input].
 *
 * @param value the input [String] text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param modifier optional [Modifier] for this text field.
 * @param label input label.
 * @param placeholder a clue to fill the input.
 * @param clearOptionDescription a description to clean icon.
 * @param error associated message.
 * @param enabled controls the enabled state of the [BasicTextField]. When `false`, the text
 * field will be neither editable nor focusable, the input of the text field will not be selectable
 * @param readOnly controls the editable state of the [BasicTextField]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param keyboardOptions software keyboard options that contains configuration such as
 * [KeyboardType] and [ImeAction].
 * @param keyboardActions when the input service emits an IME action, the corresponding callback
 * is called. Note that this IME action may be different from what you specified in
 * [KeyboardOptions.imeAction].
 * @param maxLines the maximum height in terms of maximum number of visible lines.
 * @param minLines the minimum height in terms of minimum number of visible lines.
 * representation of the input. By default no visual transformation is applied.
 * @param onTextLayout Callback that is executed when a new text layout is calculated. A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details. The callback can be used to add additional decoration or
 * functionality to the text. For example, to draw a cursor or selection around the text.
 */
@Composable
public fun TextArea(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    clearOptionDescription: String? = null,
    error: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    maxLines: Int = 3,
    minLines: Int = 3,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    Input(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.height(IntrinsicSize.Max),
        label = label,
        placeholder = placeholder,
        clearOptionDescription = clearOptionDescription,
        error = error,
        enabled = enabled,
        readOnly = readOnly,
        maxLines = maxLines,
        minLines = minLines,
        visualTransformation = VisualTransformation.None,
        onTextLayout = onTextLayout,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Preview
@Composable
private fun InputTextPreview() {
    FunBlocksTheme {
        Input(
            value = "",
            onValueChange = {},
            label = "Text area",
            placeholder = "Text area placeholder"
        )
    }
}
