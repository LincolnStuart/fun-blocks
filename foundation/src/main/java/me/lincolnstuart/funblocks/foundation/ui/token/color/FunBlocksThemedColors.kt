package me.lincolnstuart.funblocks.foundation.ui.token.color

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

/**
 * Data class that creates a custom Fun Blocks color theme.
 */
public data class FunBlocksThemedColors(
    val surface: FunBlocksColor,
    val surfaceMedium: FunBlocksColor,
    val surfaceDark: FunBlocksColor,
    val border: FunBlocksColor,
    val borderMedium: FunBlocksColor,
    val borderDark: FunBlocksColor,
    val neutral: FunBlocksColor,
    val neutralLight: FunBlocksColor,
    val neutralDark: FunBlocksColor,
    val primary: FunBlocksColor,
    val primaryLight: FunBlocksColor,
    val primaryDark: FunBlocksColor,
    val secondary: FunBlocksColor,
    val secondaryDark: FunBlocksColor,
    val reversed: FunBlocksColor,
    val info: FunBlocksColor,
    val infoMedium: FunBlocksColor,
    val infoDark: FunBlocksColor,
    val positive: FunBlocksColor,
    val positiveMedium: FunBlocksColor,
    val positiveDark: FunBlocksColor,
    val warning: FunBlocksColor,
    val warningMedium: FunBlocksColor,
    val warningDark: FunBlocksColor,
    val negative: FunBlocksColor,
    val negativeMedium: FunBlocksColor,
    val negativeDark: FunBlocksColor,
    val data1: FunBlocksColor,
    val data2: FunBlocksColor,
    val data3: FunBlocksColor,
    val data4: FunBlocksColor,
    val data5: FunBlocksColor,
    val data6: FunBlocksColor,
    val data7: FunBlocksColor,
    val data8: FunBlocksColor,
    val data9: FunBlocksColor,
    val data10: FunBlocksColor
) {

    fun update(isDarkThemeApplied: Boolean) =
        listOf(
            surface.updateValue(isDarkThemeApplied),
            surfaceMedium.updateValue(isDarkThemeApplied),
            surfaceDark.updateValue(isDarkThemeApplied),
            border.updateValue(isDarkThemeApplied),
            borderMedium.updateValue(isDarkThemeApplied),
            borderDark.updateValue(isDarkThemeApplied),
            neutral.updateValue(isDarkThemeApplied),
            neutralLight.updateValue(isDarkThemeApplied),
            neutralDark.updateValue(isDarkThemeApplied),
            primary.updateValue(isDarkThemeApplied),
            primaryDark.updateValue(isDarkThemeApplied),
            secondary.updateValue(isDarkThemeApplied),
            secondaryDark.updateValue(isDarkThemeApplied),
            reversed.updateValue(isDarkThemeApplied),
            info.updateValue(isDarkThemeApplied),
            infoMedium.updateValue(isDarkThemeApplied),
            positive.updateValue(isDarkThemeApplied),
            positiveMedium.updateValue(isDarkThemeApplied),
            warning.updateValue(isDarkThemeApplied),
            warningMedium.updateValue(isDarkThemeApplied),
            negative.updateValue(isDarkThemeApplied),
            negativeMedium.updateValue(isDarkThemeApplied),
            data1.updateValue(isDarkThemeApplied),
            data2.updateValue(isDarkThemeApplied),
            data3.updateValue(isDarkThemeApplied),
            data4.updateValue(isDarkThemeApplied),
            data5.updateValue(isDarkThemeApplied),
            data6.updateValue(isDarkThemeApplied),
            data7.updateValue(isDarkThemeApplied),
            data8.updateValue(isDarkThemeApplied),
            data9.updateValue(isDarkThemeApplied),
            data10.updateValue(isDarkThemeApplied)
        )

    fun getMaterialColors(isDarkThemeApplied: Boolean): Colors =
        Colors(
            primary = primary.value,
            primaryVariant = primaryDark.value,
            secondary = secondary.value,
            secondaryVariant = secondaryDark.value,
            background = surface.value,
            surface = surface.value,
            error = negative.value,
            onPrimary = reversed.value,
            onSecondary = neutral.value,
            onBackground = neutral.value,
            onSurface = neutral.value,
            onError = reversed.value,
            isLight = isDarkThemeApplied.not()
        )

    companion object {

        /**
         * Lego is an preset color theme for FunBlocks.
         *
         * Using [Flat UI Colors CN](https://flatuicolors.com/palette/cn) as the main color base and
         * [Flat UI Colors TR](https://flatuicolors.com/palette/tr) as the data color base
         */
        val Lego: FunBlocksThemedColors = FunBlocksThemedColors(
            surface = FunBlocksColor(light = Color(0xffffffff), dark = Color(0xff2f3542)),
            surfaceMedium = FunBlocksColor(light = Color(0xfff1f2f6), dark = Color(0xff57606f)),
            surfaceDark = FunBlocksColor(light = Color(0xffdfe4ea), dark = Color(0xff747d8c)),
            border = FunBlocksColor(light = Color(0xffced6e0), dark = Color(0xffa4b0be)),
            borderMedium = FunBlocksColor(light = Color(0xff747d8c), dark = Color(0xffdfe4ea)),
            borderDark = FunBlocksColor(light = Color(0xff57606f), dark = Color(0xfff1f2f6)),
            neutral = FunBlocksColor(light = Color(0xff57606f), dark = Color(0xffdfe4ea)),
            neutralLight = FunBlocksColor(light = Color(0xffa4b0be), dark = Color(0xff57606f)),
            neutralDark = FunBlocksColor(light = Color(0xff2f3542), dark = Color(0xfff1f2f6)),
            primary = FunBlocksColor(light = Color(0xffff7f50), dark = Color(0xffff7f50)),
            primaryLight = FunBlocksColor(light = Color(0xfffca281), dark = Color(0xfffca281)),
            primaryDark = FunBlocksColor(light = Color(0xffff6348), dark = Color(0xffff6348)),
            secondary = FunBlocksColor(light = Color(0xfff1f2f6), dark = Color(0xff747d8c)),
            secondaryDark = FunBlocksColor(light = Color(0xffdfe4ea), dark = Color(0xff57606f)),
            reversed = FunBlocksColor(light = Color(0xffffffff), dark = Color(0xff2f3542)),
            info = FunBlocksColor(light = Color(0xff70a1ff), dark = Color(0xff70a1ff)),
            infoMedium = FunBlocksColor(light = Color(0xff1e90ff), dark = Color(0xff1e90ff)),
            infoDark = FunBlocksColor(light = Color(0xff01488f), dark = Color(0xff01488f)),
            positive = FunBlocksColor(light = Color(0xff7bed9f), dark = Color(0xff7bed9f)),
            positiveMedium = FunBlocksColor(light = Color(0xff2ed573), dark = Color(0xff2ed573)),
            positiveDark = FunBlocksColor(light = Color(0xff177a41), dark = Color(0xff177a41)),
            warning = FunBlocksColor(light = Color(0xffeccc68), dark = Color(0xffeccc68)),
            warningMedium = FunBlocksColor(light = Color(0xffffa502), dark = Color(0xffffa502)),
            warningDark = FunBlocksColor(light = Color(0xff9c6602), dark = Color(0xff9c6602)),
            negative = FunBlocksColor(light = Color(0xffff6b81), dark = Color(0xffff6b81)),
            negativeMedium = FunBlocksColor(light = Color(0xffff4757), dark = Color(0xffff4757)),
            negativeDark = FunBlocksColor(light = Color(0xff87272f), dark = Color(0xff87272f)),
            data1 = FunBlocksColor(light = Color(0xffc56cf0), dark = Color(0xffcd84f1)),
            data2 = FunBlocksColor(light = Color(0xffffb8b8), dark = Color(0xffffcccc)),
            data3 = FunBlocksColor(light = Color(0xffff3838), dark = Color(0xffff4d4d)),
            data4 = FunBlocksColor(light = Color(0xffff9f1a), dark = Color(0xffffaf40)),
            data5 = FunBlocksColor(light = Color(0xfffff200), dark = Color(0xfffffa65)),
            data6 = FunBlocksColor(light = Color(0xff3ae374), dark = Color(0xff32ff7e)),
            data7 = FunBlocksColor(light = Color(0xff67e6dc), dark = Color(0xff7efff5)),
            data8 = FunBlocksColor(light = Color(0xff17c0eb), dark = Color(0xff18dcff)),
            data9 = FunBlocksColor(light = Color(0xff7158e2), dark = Color(0xff7d5fff)),
            data10 = FunBlocksColor(light = Color(0xff3d3d3d), dark = Color(0xff4b4b4b))
        )
    }
}
