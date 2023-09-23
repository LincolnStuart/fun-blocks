package me.lincolnstuart.funblocks.components.form.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import compose.icons.TablerIcons
import compose.icons.tablericons.X
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.core.text.utils.topic.TopicSize
import me.lincolnstuart.funblocks.components.form.utils.BasicInputSkeleton
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.theme.LocalTheme
import me.lincolnstuart.funblocks.foundation.ui.theme.Theme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Basic input text component, based on [BasicTextField].
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
 * @param maxLines the maximum height in terms of maximum number of visible lines. It is required
 * that 1 <= [minLines] <= [maxLines].
 * @param minLines the minimum height in terms of minimum number of visible lines. It is required
 * that 1 <= [minLines] <= [maxLines].
 * @param visualTransformation The visual transformation filter for changing the visual
 * representation of the input. By default no visual transformation is applied.
 * @param onTextLayout Callback that is executed when a new text layout is calculated. A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details. The callback can be used to add additional decoration or
 * functionality to the text. For example, to draw a cursor or selection around the text.
 */
@Composable
public fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    clearOptionDescription: String? = null,
    error: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    maxLines: Int = 1,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    val theme = LocalTheme.current
    val textColor = FunBlocksColors.Neutral.value()
    val style = rememberStyle(theme = theme, textColor = textColor)
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        maxLines = maxLines,
        minLines = minLines,
        visualTransformation = visualTransformation,
        onTextLayout = onTextLayout,
        textStyle = style,
        cursorBrush = Brush.horizontalGradient(
            colors = listOf(
                FunBlocksColors.Primary.value(),
                FunBlocksColors.PrimaryDark.value()
            )
        ),
        decorationBox = { innerTextField ->
            BasicInputSkeleton(
                error = error,
                disabled = enabled.not() || readOnly,
                content = {
                    Row {
                        Column(modifier = Modifier.weight(1f)) {
                            label?.let {
                                Text(
                                    text = label,
                                    mode = TextMode.Topic(size = TopicSize.Small)
                                )
                            }
                            Box {
                                if (value.isEmpty()) {
                                    Text(text = placeholder.orEmpty())
                                }
                                innerTextField()
                            }
                        }
                        if (enabled && readOnly.not()) {
                            ClearOption(
                                value = value,
                                description = clearOptionDescription,
                                onClear = { onValueChange("") }
                            )
                        }
                    }
                }
            )
        }
    )
}

@Composable
private fun rememberStyle(
    theme: Theme,
    textColor: Color
) = remember {
    val mode = TextMode.Regular()
    TextStyle(
        fontFamily = theme.fontFamily,
        fontWeight = mode.fontWeight,
        fontSize = mode.fontSize,
        color = textColor
    )
}

@Composable
private fun RowScope.ClearOption(
    value: String,
    description: String?,
    onClear: () -> Unit
) {
    val isClearOptionVisible = remember(value) {
        value.isNotEmpty()
    }
    if (isClearOptionVisible) {
        Icon(
            imageVector = TablerIcons.X,
            options = IconOptions(
                description = description,
                size = IconSize.Tiny
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable { onClear() }
        )
    }
}

// @Preview
@Composable
private fun InputTextPreview() {
    FunBlocksTheme {
        Input(
            value = "",
            onValueChange = {},
            label = "Input",
            placeholder = "Input placeholder"
        )
    }
}
