package com.drobie.client.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DrobieColors(
    val background: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val surface: Color,
    val border: Color,
    val buttonBackground: Color,
    val buttonText: Color,
    val error: Color,
)

val DrobieLightColors = DrobieColors(
    background = DrobieWhite,
    textPrimary = DrobieBlack,
    textSecondary = Gray600,
    surface = Gray100,
    border = Gray300,
    buttonBackground = DrobieBlack,
    buttonText = DrobieWhite,
    error = ErrorLight,
)

val DrobieDarkColors = DrobieColors(
    background = DrobieBlack,
    textPrimary = DrobieWhite,
    textSecondary = Gray400,
    surface = Gray900,
    border = Gray700,
    buttonBackground = DrobieWhite,
    buttonText = DrobieBlack,
    error = ErrorDark,
)
