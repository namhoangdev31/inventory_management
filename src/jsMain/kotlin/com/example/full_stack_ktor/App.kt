package com.example.full_stack_ktor

import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import com.example.full_stack_ktor.app.AppRouter
import com.example.full_stack_ktor.app.AppRouterViewModel
import com.example.full_stack_ktor.app.initializeKoin
import com.example.full_stack_ktor.ui.cms.admin.adminCmsPage
import com.example.full_stack_ktor.ui.cms.login.loginCMSAdminPage
import com.example.full_stack_ktor.ui.home_page.presentation.homePage
import com.example.full_stack_ktor.ui.login_page.presentation.loginPage
import com.example.full_stack_ktor.ui.register_page.presentation.registerPage
import com.example.full_stack_ktor.ui.super_admin.superAdmin
import io.kvision.*
import io.kvision.html.div
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
			div().bind(router) { appRouterState ->
				val routerState = appRouterState.backstack
				routerState.renderCurrentDestination(
					route = { appRouter ->
						when (appRouter) {
							AppRouter.Root -> homePage()
							AppRouter.Home -> homePage()
							AppRouter.Login -> loginPage()
							AppRouter.Signup -> registerPage()
							AppRouter.About -> div { +"About Page" }
							AppRouter.CMSHeader -> div { +"CMS Header Page" }
							AppRouter.CMSContent -> div { +"CMS Content Page" }
							AppRouter.CMSPage -> div { +"CMS Page Page" }
							AppRouter.CMSBlog -> div { +"CMS Blog Page" }
							AppRouter.CMSPost -> div { +"CMS Post Page" }
							AppRouter.CMSAdmin -> adminCmsPage()
							AppRouter.CMSMedia -> div { +"CMS Media Page" }
							AppRouter.CMSFooter -> div { +"CMS Footer Page" }
							AppRouter.CMSCategories -> div { +"CMS Categories" }
							AppRouter.CMSSiderBar -> div { +"CMS Bar Page" }
							AppRouter.CMSLogin -> loginCMSAdminPage()
							AppRouter.SuperAdmin -> superAdmin()
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
		}
	}
}