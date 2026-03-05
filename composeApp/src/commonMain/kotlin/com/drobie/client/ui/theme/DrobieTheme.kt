package com.drobie.client.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalDrobieColors = staticCompositionLocalOf { DrobieLightColors }

@Composable
fun DrobieTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) DrobieDarkColors else DrobieLightColors

    CompositionLocalProvider(LocalDrobieColors provides colors) {
        content()
    }
}

object DrobieTheme {
    val colors: DrobieColors
        @Composable
        get() = LocalDrobieColors.current
}
