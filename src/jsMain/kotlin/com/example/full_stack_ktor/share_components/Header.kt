package com.example.full_stack_ktor.share_components

import com.example.full_stack_ktor.AppRouter
import io.kvision.core.Container
import io.kvision.html.*

fun Container.headerComponent(router: AppRouter) {
    nav(className = "header") {
        div(className = "header_logo") {
            img(src = "images/logo.png", className = "logo-icon")
        }
        div(className = "header__title") {
            h1("My Application")
        }
        nav(className = "header__nav") {
            ul {
                li { a(href = "/home", label =  "Home" , className = "nav-item") }
                li { a(href = "/about", label =  "About" , className ="") }
                li { a(href = "/contact", label =  "Contact" , className = "nav-item") }
            }
        }
    }
}