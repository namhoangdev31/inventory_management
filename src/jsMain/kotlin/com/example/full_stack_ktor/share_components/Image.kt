package com.example.full_stack_ktor.share_components

import io.kvision.core.Container
import io.kvision.html.Image
import io.kvision.html.Link
import io.kvision.html.image

fun Container.img(className: String, src: String, alt: String = "" ,  block: Image.() -> Unit = {}): Image {
    return image(className = className, src = src , alt = alt).apply {
        block()
    }
}