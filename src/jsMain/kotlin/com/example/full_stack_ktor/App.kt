package com.example.full_stack_ktor

import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import io.kvision.Application
import io.kvision.html.div
import io.kvision.panel.root
import io.kvision.state.bind
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.example.full_stack_ktor.model.*
import com.example.full_stack_ktor.ui.login_page.presentation.loginPage
import io.kvision.BootstrapCssModule
import io.kvision.BootstrapIconsModule
import io.kvision.BootstrapModule
import io.kvision.ChartModule
import io.kvision.CoreModule
import io.kvision.DatetimeModule
import io.kvision.FontAwesomeModule
import io.kvision.ImaskModule
import io.kvision.MapsModule
import io.kvision.PrintModule
import io.kvision.RichTextModule
import io.kvision.TabulatorCssBootstrapModule
import io.kvision.TabulatorModule
import io.kvision.ToastifyModule
import io.kvision.TomSelectModule
import io.kvision.module
import io.kvision.startApplication
import io.kvision.toast.Toast
import org.koin.core.context.GlobalContext.startKoin
import kotlin.getValue

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application(), KoinComponent {

    init {
        io.kvision.require("css/tailwind.min.css")
        io.kvision.require("css/tailwind.css")
        io.kvision.require("css/kvapp.css")
    }

    override fun start(state: Map<String, Any>) {
        root("kvapp") {
            val router by inject<AppRouterViewModel>()
            div().bind(router) { appRouterState ->
                val routerState = appRouterState.backstack
                console.log("Router State: $appRouterState")
                routerState.renderCurrentDestination(
                    route = { appRouter ->
                        when (appRouter) {
                            AppRouter.Root -> div(className = "container") {
                                + "Welcome to the Home Page"
                            }
                            AppRouter.Home -> loginPage()
	                        AppRouter.Login -> div {
                                + "Welcome to the Home Page"
                            }
	                        AppRouter.Signup -> div {
                                + "Welcome to the Home Page"
                            }
	                        AppRouter.ContactList -> div {
                                + "Welcome to the Home Page"
                            }
	                        AppRouter.ContactAdd -> div {
                                + "Welcome to the Home Page"
                            }
	                        AppRouter.ContactDetail -> div {
                                + "Welcome to the Home Page"
                            }
                        }
                    },
                    notFound = {
                        Toast.danger("Route not found!")
                        console.log("Route not found! Going home...")
                        router.trySend(
                            RouterContract.Inputs.GoToDestination(
                                AppRouter.Home.directions().build()
                            )
                        )
                    }
                )
            }
        }
    }
}

fun main() {
    startKoin {
        modules(routerModule)
    }
    startApplication(
        ::App,
        module.hot,
        BootstrapModule,
        DatetimeModule,
        RichTextModule,
        TomSelectModule,
        ImaskModule,
        ToastifyModule,
        FontAwesomeModule,
        BootstrapIconsModule,
//        BootstrapCssModule,
        PrintModule,
        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        MapsModule,
        CoreModule,
    )
}
