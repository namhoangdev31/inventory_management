package com.example.full_stack_ktor.ui.cms

import com.example.full_stack_ktor.share_components.a
import com.example.full_stack_ktor.share_components.img
import io.kvision.core.Container
import io.kvision.core.onClick
import io.kvision.html.ButtonType
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.footer
import io.kvision.html.*
import kotlinx.browser.window

fun Container.headerCMSComponent() {
	nav(className = "w-full bg-white shadow-sm px-6 py-4 flex justify-between items-center") {
		
		// Logo
		div(className = "flex items-center gap-3 cursor-pointer") {
			img(src = "images/logo.png", className = "w-8 h-8") {
				onClick {
					// Navigate or home
				}
			}
		}
		
		// Navigation
		nav(className = "hidden md:flex space-x-6") {
			ul(className = "flex gap-6") {
				listOf(
					"Pages" to "/cms-admin/pages",
					"Products" to "/cms-admin/products",
					"Orders" to "/cms-admin/orders",
					"Media" to "/cms-admin/media",
					"Categories" to "/cms-admin/categories",
					"Users" to "/cms-admin/users",
					"Redirects" to "/cms-admin/redirects",
					"Globals" to "/cms-admin/globals"
				).forEach { (label, link) ->
					li {
						a(href = link, className = "text-sm font-normal text-gray-700 hover:text-blue-600") {
							+label
						}
					}
				}
			}
		}
		
		// Logout button
		div(className = "flex items-center gap-3") {
			button(
				type = ButtonType.BUTTON,
				className = "flex items-center gap-2 px-3 py-2 rounded text-sm font-medium text-gray-700 hover:text-blue-600 hover:bg-gray-100 transition",
				text = "Logout"
			).onClick {
				window.location.href = "/cms-admin/logout"
			}
		}
	}
}

fun Container.footerCMSComponent() {
	footer(className = "bg-white border-t p-4 text-center text-14 text-gray-500 mt-auto") {
		+"© 2025 PainCMS. All rights reserved."
	}
}