package me.lincolnstuart.funblocks.components.core.text.utils

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import me.lincolnstuart.funblocks.components.core.text.utils.regular.RegularSize
import me.lincolnstuart.funblocks.components.core.text.utils.regular.RegularWeight
import me.lincolnstuart.funblocks.components.core.text.utils.subtitle.SubtitleSize
import me.lincolnstuart.funblocks.components.core.text.utils.title.TitleSize
import me.lincolnstuart.funblocks.components.core.text.utils.topic.TopicSize
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontWeight
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksLetterSpace

/**
 * Sealed class that presets the Text component customization.
 *
 * @param fontSize [TextUnit], it is recommended to use [FunBlocksFontSize].
 * @param fontWeight [FontWeight], it is recommended to use [FunBlocksFontWeight].
 * @param letterSpace [TextUnit], it is recommended to use [FunBlocksLetterSpace].
 * @param textTransformation callback that customize the raw text.
 */
public sealed class TextMode(
    open val fontSize: TextUnit = FunBlocksFontSize.medium,
    open val fontWeight: FontWeight = FunBlocksFontWeight.regular,
    open val letterSpace: TextUnit = FunBlocksLetterSpace.regular,
    open val textTransformation: (text: String) -> String
) {
    public data class Regular(
        val size: RegularSize = RegularSize.Medium,
        val weight: RegularWeight = RegularWeight.Regular,
        override val textTransformation: (text: String) -> String = { text -> text }
    ) : TextMode(
        fontSize = size.value,
        fontWeight = weight.value,
        textTransformation = textTransformation
    )

    public data class Title(
        val size: TitleSize = TitleSize.H2,
        override val textTransformation: (text: String) -> String = { text -> text }
    ) : TextMode(
        fontSize = size.value,
        fontWeight = FunBlocksFontWeight.bold,
        textTransformation = textTransformation
    )

    public data class Subtitle(
        val size: SubtitleSize = SubtitleSize.Medium,
        override val textTransformation: (text: String) -> String = { text -> text }
    ) : TextMode(
        fontSize = size.value,
        fontWeight = FunBlocksFontWeight.semiBold,
        textTransformation = textTransformation
    )

    public data class Topic(
        val size: TopicSize = TopicSize.Large
    ) : TextMode(
        fontSize = size.value,
        fontWeight = FunBlocksFontWeight.semiBold,
        letterSpace = FunBlocksLetterSpace.large,
        textTransformation = { text -> text.uppercase() }
    )

    public data class Custom(
        override val fontSize: TextUnit = FunBlocksFontSize.medium,
        override val fontWeight: FontWeight = FunBlocksFontWeight.regular,
        override val letterSpace: TextUnit = FunBlocksLetterSpace.regular,
        override val textTransformation: (text: String) -> String = { text -> text }
    ) : TextMode(
        fontSize = fontSize,
        fontWeight = fontWeight,
        letterSpace = letterSpace,
        textTransformation = textTransformation
    )
}
