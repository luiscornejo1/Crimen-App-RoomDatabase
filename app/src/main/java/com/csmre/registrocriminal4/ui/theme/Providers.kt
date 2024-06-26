package com.csmre.registrocriminal4.ui.theme


import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalBackPressedDispatcher = staticCompositionLocalOf<OnBackPressedDispatcher> {
    error("No BackPressedDispatcher provided")
}

@Composable
fun ProvideBackPressedDispatcher(
    backDispatcher: OnBackPressedDispatcher,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalBackPressedDispatcher provides backDispatcher) {
        content()
    }
}