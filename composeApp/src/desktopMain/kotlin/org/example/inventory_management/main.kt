package org.example.inventory_management

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "inventory_management",
    ) {
        App()
    }
}