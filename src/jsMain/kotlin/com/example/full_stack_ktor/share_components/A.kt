package com.example.full_stack_ktor.share_components

import io.kvision.core.Container
import io.kvision.html.*
import org.koin.core.component.KoinComponent


fun Container.a(className: String?, href: String = "/", label: String = "", block: Link.() -> Unit = {}): io.kvision.html.Link {
    return link(className = className , label = label , url = href).apply {
        block()
    }
}
