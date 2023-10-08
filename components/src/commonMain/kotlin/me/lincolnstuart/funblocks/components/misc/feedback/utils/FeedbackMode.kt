package me.lincolnstuart.funblocks.components.misc.feedback.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

public sealed class FeedbackMode() {

    @Composable
    internal abstract fun Content()

    data class Basic(
        val title: String,
        val painter: Painter,
        val painterDescription: String?,
        val details: String
    ) : FeedbackMode() {

        @Composable
        override fun Content() {
            Text(text = title, mode = TextMode.Title())
            VerticalSpacer(height = FunBlocksSpacing.medium)
            Image(painter = painter, contentDescription = painterDescription)
            VerticalSpacer(height = FunBlocksSpacing.small)
            Text(text = details)
        }
    }

    data class Custom(
        val title: String,
        val body: @Composable () -> Unit
    ) : FeedbackMode() {
        @Composable
        override fun Content() {
            Text(text = title, mode = TextMode.Title())
            VerticalSpacer(height = FunBlocksSpacing.medium)
            body()
        }
    }
}
