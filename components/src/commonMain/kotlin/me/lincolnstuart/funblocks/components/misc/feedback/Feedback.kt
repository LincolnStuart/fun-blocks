package me.lincolnstuart.funblocks.components.misc.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.components.misc.feedback.utils.FeedbackMode

@Composable
public fun Feedback(
    mode: FeedbackMode
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        mode.Content()
    }
}
