package com.example.full_stack_ktor.views

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.*
import io.kvision.utils.px

class HomePage : SimplePanel() {
    init {
        padding = 32.px
        alignItems = AlignItems.CENTER
        justifyContent = JustifyContent.CENTER
        borderRadius = 16.px
        boxShadow = BoxShadow(blurRadius = 12.px, color = Color("rgba(0, 0, 0, 0.1)"))

        h1 {
            +"🏠 Home Page"
            fontSize = 28.px
            color = Color.name(Col.LIGHTYELLOW)
            fontWeight = FontWeight.BOLD
        }
    }
}
