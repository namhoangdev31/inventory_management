package com.example.full_stack_ktor.share_components

import io.kvision.core.Container
import io.kvision.html.Div
import io.kvision.html.div

fun Container.previewHtml(htmlContent: Div): Div {
    return div(className = "bg-green-50 h-1/2 w-1/2 fixed border-2 rounded-lg").apply {
       add(htmlContent)
    }
}