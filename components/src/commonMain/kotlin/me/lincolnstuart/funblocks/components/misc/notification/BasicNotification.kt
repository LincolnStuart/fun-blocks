package me.lincolnstuart.funblocks.components.misc.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Base component that organize the main content and notification indicator.
 *
 * @param displacement it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param content the content inside.
 * @param notification the indicator.
 */
@Composable
internal fun BasicNotification(
    displacement: PaddingValues,
    content: @Composable () -> Unit,
    notification: @Composable BoxScope.() -> Unit
) {
    Box {
        Box(
            modifier = Modifier.padding(displacement)
        ) {
            content()
        }
        Box(
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            notification()
        }
    }
}
