package com.mhmdbh.portfolio

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Portfolio",
    ) {
        App(DpSize(1024.dp,740.dp)) {}
    }
}