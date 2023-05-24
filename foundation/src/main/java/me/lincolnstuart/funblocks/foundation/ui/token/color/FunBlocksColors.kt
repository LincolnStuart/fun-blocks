package me.lincolnstuart.funblocks.foundation.ui.token.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import me.lincolnstuart.funblocks.foundation.ui.theme.LocalTheme

/**
 * Enum that provides the correct color, based on theme mode, for each token defined.
 *
 * @param value function that returns the correct color.
 */
public enum class FunBlocksColors(
    val value: @Composable () -> Color
) {
    Transparent({ FunBlocksColor.Transparent.value }),
    Surface({ LocalTheme.current.colors.surface.value }),
    SurfaceMedium({ LocalTheme.current.colors.surfaceMedium.value }),
    SurfaceDark({ LocalTheme.current.colors.surfaceDark.value }),
    Border({ LocalTheme.current.colors.border.value }),
    BorderMedium({ LocalTheme.current.colors.borderMedium.value }),
    BorderDark({ LocalTheme.current.colors.borderDark.value }),
    Neutral({ LocalTheme.current.colors.neutral.value }),
    NeutralLight({ LocalTheme.current.colors.neutralLight.value }),
    NeutralDark({ LocalTheme.current.colors.neutralDark.value }),
    Primary({ LocalTheme.current.colors.primary.value }),
    PrimaryLight({ LocalTheme.current.colors.primaryLight.value }),
    PrimaryDark({ LocalTheme.current.colors.primaryDark.value }),
    Secondary({ LocalTheme.current.colors.secondary.value }),
    SecondaryDark({ LocalTheme.current.colors.secondaryDark.value }),
    Reversed({ LocalTheme.current.colors.reversed.value }),
    Info({ LocalTheme.current.colors.info.value }),
    InfoMedium({ LocalTheme.current.colors.infoMedium.value }),
    InfoDark({ LocalTheme.current.colors.infoDark.value }),
    Positive({ LocalTheme.current.colors.positive.value }),
    PositiveMedium({ LocalTheme.current.colors.positiveMedium.value }),
    PositiveDark({ LocalTheme.current.colors.positiveDark.value }),
    Warning({ LocalTheme.current.colors.warning.value }),
    WarningMedium({ LocalTheme.current.colors.warningMedium.value }),
    WarningDark({ LocalTheme.current.colors.warningDark.value }),
    Negative({ LocalTheme.current.colors.negative.value }),
    NegativeMedium({ LocalTheme.current.colors.negativeMedium.value }),
    NegativeDark({ LocalTheme.current.colors.negativeDark.value }),
    Data1({ LocalTheme.current.colors.data1.value }),
    Data2({ LocalTheme.current.colors.data2.value }),
    Data3({ LocalTheme.current.colors.data3.value }),
    Data4({ LocalTheme.current.colors.data4.value }),
    Data5({ LocalTheme.current.colors.data5.value }),
    Data6({ LocalTheme.current.colors.data6.value }),
    Data7({ LocalTheme.current.colors.data7.value }),
    Data8({ LocalTheme.current.colors.data8.value }),
    Data9({ LocalTheme.current.colors.data9.value }),
    Data10({ LocalTheme.current.colors.data10.value });
}
