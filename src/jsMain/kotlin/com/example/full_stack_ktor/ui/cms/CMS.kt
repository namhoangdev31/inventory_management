package com.example.full_stack_ktor.ui.cms

import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.example.full_stack_ktor.app.AppRouter
import com.example.full_stack_ktor.app.AppRouterViewModel
import com.example.full_stack_ktor.share_components.img
import io.kvision.core.Container
import io.kvision.core.onClick
import io.kvision.html.*
import kotlinx.browser.window
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

fun Container.headerCMSComponent(): KoinComponent = object : KoinComponent {
	val router by inject<AppRouterViewModel>()
	val iconMap = mapOf(
		"Pages" to "bi-file-earmark-text",
		"Products" to "bi-box-seam",
		"Orders" to "bi-receipt-cutoff",
		"Media" to "bi-images",
		"Categories" to "bi-tags",
		"Users" to "bi-people",
		"Redirects" to "bi-arrow-left-right",
		"Globals" to "bi-globe"
	)
	
	init {
		nav(className = "w-full bg-white shadow-sm px-6 py-4 flex justify-between items-center") {
			div(className = "flex items-center gap-3 cursor-pointer") {
				img(src = "images/logo.png", className = "w-8 h-8") {
					onClick { window.location.href = "/cms-admin" }
				}
			}
			nav(className = "hidden md:flex space-x-6") {
				ul(className = "flex gap-6") {
					listOf(
						"Pages" to AppRouter.CMSPage,
						"Products" to AppRouter.CMSProducts,
						"Orders" to AppRouter.CMSOrders,
						"Media" to AppRouter.CMSMedia,
						"Categories" to AppRouter.CMSCategories,
						"Users" to AppRouter.CMSUser,
						"Redirects" to AppRouter.CMSRedirects,
						"Globals" to AppRouter.CMSGlobals
					).forEach { (label, link) ->
						li {
							button(className = "text-sm font-normal text-gray-700 hover:text-blue-600 active:", text = label) {
								onClick { event ->
									router.trySend(
										RouterContract.Inputs.GoToDestination(
											link.directions().build()
										)
									)
								}
							}
						}
					}
				}
			}
			div(className = "flex items-center gap-3") {
				div(className = "flex md:hidden gap-2") {
					iconMap.forEach { (label, icon) ->
						val path = "/cms-admin/${label.lowercase()}"
						button(
							type = ButtonType.BUTTON,
							className = "px-1 rounded hover:bg-gray-100",
							text = "",
							icon = icon
						).onClick {
							window.location.href = path
						}
					}
				}
				button(
					type = ButtonType.BUTTON,
					icon = "bi bi-box-arrow-right",
					className = "flex items-center gap-2 md:px-3 md:py-2 rounded text-sm font-medium text-gray-700 hover:text-blue-600 hover:bg-gray-100 transition p-2",
					text = ""
				).onClick {
					window.location.href = "/cms-admin/logout"
				}
			}
		}
	}
}

fun Container.footerCMSComponent() {
	footer(className = "bg-white p-4 text-center text-14 text-gray-500 mt-auto") {
		+"© 2025 PainCMS. All rights reserved."
	}
}