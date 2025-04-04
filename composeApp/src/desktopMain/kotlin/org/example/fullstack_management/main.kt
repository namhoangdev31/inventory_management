package org.example.fullstack_management

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "fullstack_management",
    ) {
        App()
    }
}