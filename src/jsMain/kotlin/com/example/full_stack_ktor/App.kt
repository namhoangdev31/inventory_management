package com.example.full_stack_ktor

import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.currentDestinationOrNull
import com.copperleaf.ballast.navigation.routing.currentRouteOrNull
import com.copperleaf.ballast.navigation.routing.directions
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import com.example.full_stack_ktor.app.AppRouter
import com.example.full_stack_ktor.app.AppRouterViewModel
import com.example.full_stack_ktor.app.initializeKoin
import com.example.full_stack_ktor.share_components.footerMasterComponent
import com.example.full_stack_ktor.share_components.headerMasterComponent
import com.example.full_stack_ktor.share_components.notFoundPage
import com.example.full_stack_ktor.share_components.sideBarComponent
import com.example.full_stack_ktor.ui.cms.admin.adminCmsPage
import com.example.full_stack_ktor.ui.cms.login.loginCMSAdminPage
import com.example.full_stack_ktor.ui.cms.pages.pagesCMSView
import com.example.full_stack_ktor.ui.home_page.presentation.homePage
import com.example.full_stack_ktor.ui.login_page.presentation.loginPage
import com.example.full_stack_ktor.ui.register_page.presentation.registerPage
import com.example.full_stack_ktor.ui.super_admin.superAdminPage
import io.kvision.*
import io.kvision.html.div
import io.kvision.html.footer
import io.kvision.html.header
import io.kvision.panel.root
import io.kvision.state.bind
import io.kvision.toast.Toast
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

fun main() {
	initializeKoin()
	startApplication(
		::App,
		module.hot,
		BootstrapModule,
		DatetimeModule,
		RichTextModule,
		TomSelectModule,
		ImaskModule,
		ToastifyModule,
		PrintModule,
		ChartModule,
		TabulatorModule,
		MapsModule,
		CoreModule,
		BootstrapIconsModule,
		FontAwesomeModule,
	)
}

class App : Application(), KoinComponent {
	
	init {
		require("css/kvapp.css")
		require("css/base.css")
		require("css/components.css")
		require("css/utilities.css")
		require("css/media.css")
		require("css/media_md.css")
		require("css/media_lg.css")
		require("css/media_xl.css")
		require("css/media_2xl.css")
		require("css/utilities_sm.css")
		require("css/utilities_md.css")
		require("css/utilities_lg.css")
		require("css/utilities_xl.css")
		require("css/utilities_2xl.css")
		require("css/utilities_two.css")
	}
	
	override fun start(state: Map<String, Any>) {
		root("kvapp") {
			val router by inject<AppRouterViewModel>()
			header().bind(router) { appRouterState ->
				headerMasterComponent(
					appRouterState.backstack.currentDestinationOrNull?.originalRoute ?: AppRouter.Root
				)
			}
			div().bind(router) { appRouterState ->
				val routerState = appRouterState.backstack
				routerState.renderCurrentDestination(
					route = { appRouter ->
						when (appRouter) {
							AppRouter.Root -> homePage()
							AppRouter.Admin -> superAdminPage()
							AppRouter.Login -> loginPage()
							AppRouter.Signup -> registerPage()
							AppRouter.About -> div { +"About Page" }
							AppRouter.CMSHeader -> div { +"CMS Header Page" }
							AppRouter.CMSHeaderUpdate -> div { +"CMS Header Update Page" }
							AppRouter.CMSContent -> div { +"CMS Content Page" }
							AppRouter.CMSPage -> pagesCMSView()
							AppRouter.CMSPageDetail -> div { +"CMS Page Detail Page" }
							AppRouter.CMSPageCreate -> div { +"CMS Page Create Page" }
							AppRouter.CMSBlog -> div { +"CMS Blog Page" }
							AppRouter.CMSPost -> div { +"CMS Post Page" }
							AppRouter.CMSPostDetail -> div { +"CMS Product Page" }
							AppRouter.CMSAdmin -> adminCmsPage()
							AppRouter.CMSMedia -> div { +"CMS Media Page" }
							AppRouter.CMSFooter -> div { +"CMS Footer Page" }
							AppRouter.CMSCategories -> div { +"CMS Categories" }
							AppRouter.CMSSiderBar -> div { +"CMS Bar Page" }
							AppRouter.CMSLogin -> loginCMSAdminPage()
							AppRouter.CMSProducts -> div{ +"CMS Products Page" }
							AppRouter.CMSUser -> div { +"CMS User Page" }
							AppRouter.CMSOrders -> div { +"CMS Orders" }
							AppRouter.CMSGlobals -> div { +"CMS Globals" }
							AppRouter.CMSRedirects -> div { +"CMS Redirect Page" }
							AppRouter.CMSPageEdit -> div { +"CMS Edit Page" }
							else -> notFoundPage()
						}
					},
					notFound = {
						Toast.danger("Route not found!")
						console.log("Route not found! Going home...")
						router.trySend(
							RouterContract.Inputs.GoToDestination(
								AppRouter.Root.directions().build()
							)
						)
					}
				)
			}
			footer().bind(router) { appRouterState ->
				footerMasterComponent(
					appRouterState.backstack.currentDestinationOrNull?.originalRoute ?: AppRouter.Root
				)
			}
		}
	}
}