package me.lincolnstuart.funblocks.essentials.core.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.theme.LocalTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Element that displays a plain text
 * (composable based on [androidx.compose.foundation.text.BasicText])
 * @param text the text to be displayed.
 * @param modifier [Modifier] to apply to this layout node.
 * @param mode the type variant to style the text
 * @param style the typeface variant to use when drawing the letters (e.g., italic)
 * @param color the text color
 * @param overflow how visual overflow should be handled.
 * @param softWrap whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines an optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. It is required that 1 <= [minLines] <= [maxLines].
 * @param minLines the minimum height in terms of minimum number of visible lines. It is required
 * that 1 <= [minLines] <= [maxLines].
 * @param onTextLayout callback that is executed when a new text layout is calculated. A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details. The callback can be used to add additional decoration or
 * functionality to the text. For example, to draw selection around the text.
 */
@Composable
public fun Text(
    text: String,
    modifier: Modifier = Modifier,
    mode: TextMode = TextMode.Regular(),
    style: FontStyle = FontStyle.Normal,
    color: FunBlocksColors = FunBlocksColors.Neutral,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {
    Text(
        annotatedString = AnnotatedString(text),
        modifier = modifier,
        mode = mode,
        style = style,
        color = color.value(),
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}

/**
 * Element that displays a plain text
 * (composable based on [androidx.compose.foundation.text.BasicText])
 * @param annotatedString the text to be displayed.
 * @param modifier [Modifier] to apply to this layout node.
 * @param mode the type variant to style the text
 * @param style the typeface variant to use when drawing the letters (e.g., italic)
 * @param color the text color
 * @param overflow how visual overflow should be handled.
 * @param softWrap whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines an optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. It is required that 1 <= [minLines] <= [maxLines].
 * @param minLines the minimum height in terms of minimum number of visible lines. It is required
 * that 1 <= [minLines] <= [maxLines].
 * @param onTextLayout callback that is executed when a new text layout is calculated. A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details. The callback can be used to add additional decoration or
 * functionality to the text. For example, to draw selection around the text.
 */
@Composable
public fun Text(
    annotatedString: AnnotatedString,
    modifier: Modifier = Modifier,
    mode: TextMode = TextMode.Regular(),
    style: FontStyle = FontStyle.Normal,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {
    val transformedText = remember(annotatedString) {
        mode.textTransformation(annotatedString.text)
    }
    val fontFamily = LocalTheme.current.fontFamily
    BasicText(
        text = transformedText,
        modifier = modifier,
        style = TextStyle(
            fontSize = mode.fontSize,
            fontWeight = mode.fontWeight,
            fontStyle = style,
            fontFamily = fontFamily,
            color = color,
            letterSpacing = mode.letterSpace
        ),
        maxLines = maxLines,
        overflow = overflow,
        softWrap = softWrap,
        minLines = minLines,
        onTextLayout = onTextLayout
    )
}

@Preview
@Composable
private fun TextPreview() {
    FunBlocksTheme {
        Surface {
            Column {
                Text(text = "Title", mode = TextMode.Title())
                Text(text = "Subtitle", mode = TextMode.Subtitle())
                Text(text = "Topic", mode = TextMode.Topic())
                Text(text = "regular")
            }
        }
    }
}
