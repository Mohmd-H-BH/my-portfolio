package com.mhmdbh.portfolio

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
fun rememberWindowSize(): DpSize {
    // MutableState to track the raw window size
    var windowSize by remember { mutableStateOf(DpSize.Zero) }

    // derivedStateOf to avoid recomposition unless the size actually changes
    val derivedWindowSize by remember {
        derivedStateOf { windowSize }
    }

    // Listen for window resize events
    LaunchedEffect(Unit) {
        window.onresize = {
            windowSize = DpSize(
                window.innerWidth.dp,
                window.innerHeight.dp
            )
        }

        // Initialize the size on first composition
        windowSize = DpSize(
            window.innerWidth.dp,
            window.innerHeight.dp
        )
    }

    return derivedWindowSize
}

@Composable
fun rememberWindowSizeOld(): DpSize {

    var windowSize by remember { mutableStateOf(DpSize.Zero) }

    // LaunchedEffect listens for changes in the composition
    LaunchedEffect(Unit) {
        // Listen for window resize events
        window.onresize = {
            windowSize = DpSize(
                window.innerWidth.dp,
                window.innerHeight.dp
            )
        }

        // Initialize the size on first composition
        windowSize = DpSize(
            window.innerWidth.dp,
            window.innerHeight.dp
        )
    }

    return windowSize
}