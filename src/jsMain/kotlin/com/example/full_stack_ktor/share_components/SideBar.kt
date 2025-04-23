package com.example.full_stack_ktor.share_components

import com.example.full_stack_ktor.app.AppRouter
import io.kvision.core.Container
import io.kvision.html.*

fun Container.sideBarComponent(router: AppRouter) {
	when (router) {
		AppRouter.CMSAdmin -> {
			nav(className = "sidebar") {
				ul {
					li { a(href = "/home", label = "Home", className = "nav-item") }
					li { a(href = "/about", label = "About", className = "") }
					li { a(href = "/contact", label = "Contact", className = "nav-item") }
				}
			}
		}
		else -> {
			div(className = "hidden")
		}
	}
}