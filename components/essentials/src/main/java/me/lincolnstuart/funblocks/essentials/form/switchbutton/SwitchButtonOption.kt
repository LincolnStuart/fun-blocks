package me.lincolnstuart.funblocks.essentials.form.switchbutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.helper.SimpleItem

/**
 * Switch option. Based on [SwitchButton].
 *
 * @param description option description.
 * @param isOn if switch is on.
 * @param onClick callback that executes when click is performed and returns the the new switch state.
 * @param modifier optional [Modifier].
 */
@Composable
public fun SwitchButtonOption(
    description: String,
    isOn: Boolean,
    onClick: (isOn: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            SimpleItem {
                Text(description)
            }
        }
        SwitchButton(isOn = isOn, onClick = onClick)
    }
}
