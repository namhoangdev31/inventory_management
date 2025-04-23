package com.example.full_stack_ktor.ui.cms

import com.example.full_stack_ktor.share_components.a
import com.example.full_stack_ktor.share_components.img
import io.kvision.core.Container
import io.kvision.core.onClick
import io.kvision.html.div
import io.kvision.html.footer
import io.kvision.html.h1
import io.kvision.html.li
import io.kvision.html.nav
import io.kvision.html.ul

fun Container.headerCMSComponent() {
	nav(className = "w-full bg-white shadow-md px-6 py-4 flex justify-between items-center") {
		
		div(className = "flex items-center gap-3 cursor-pointer") {
			img(src = "images/logo.png", className = "w-8 h-8") {
				onClick { event ->
					// Add your redirect or action
				}
			}
			h1(className = "text-xl font-bold text-gray-800") {
				+"My Application"
			}
		}
		
		nav(className = "hidden md:flex space-x-6") {
			ul(className = "flex gap-6") {
				li {
					a(href = "/home", className = "text-sm font-medium text-gray-700 hover:text-blue-600") {
						+"Home"
					}
				}
				li {
					a(href = "/about", className = "text-sm font-medium text-gray-700 hover:text-blue-600") {
						+"About"
					}
				}
				li {
					a(href = "/contact", className = "text-sm font-medium text-gray-700 hover:text-blue-600") {
						+"Contact"
					}
				}
			}
		}
	}
}


fun Container.footerCMSComponent(){
	footer(className = "footer-cms bg-light p-3 border-top mt-auto") {
		div(className = "container text-center text-muted text-sm") {
			+"© 2024 DNBC CMS. All rights reserved."
		}
	}
}