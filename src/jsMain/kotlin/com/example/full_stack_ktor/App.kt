package com.example.full_stack_ktor

import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import com.example.full_stack_ktor.ui.login_page.presentation.loginPage
import com.example.full_stack_ktor.ui.login_page.viewmodel.loginModule
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
import org.koin.core.context.GlobalContext.startKoin

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application(), KoinComponent {

    init {
        io.kvision.require("css/kvapp.css")
        io.kvision.require("css/base.css")
        io.kvision.require("css/components.css")
        io.kvision.require("css/utilities.css")
        io.kvision.require("css/media.css")
        io.kvision.require("css/media_md.css")
        io.kvision.require("css/media_lg.css")
        io.kvision.require("css/media_xl.css")
        io.kvision.require("css/media_2xl.css")
        io.kvision.require("css/utilities_sm.css")
        io.kvision.require("css/utilities_md.css")
        io.kvision.require("css/utilities_lg.css")
        io.kvision.require("css/utilities_xl.css")
        io.kvision.require("css/utilities_2xl.css")
        io.kvision.require("css/utilities_two.css")
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
                                +"Welcome to the Home Page"
                            }

                            AppRouter.Home -> loginPage()
                            AppRouter.Login -> div {
                                +"Welcome to the Home Page"
                            }

                            AppRouter.Signup -> div {
                                +"Welcome to the Home Page"
                            }

                            AppRouter.ContactList -> div {
                                +"Welcome to the Home Page"
                            }

                            AppRouter.ContactAdd -> div {
                                +"Welcome to the Home Page"
                            }

                            AppRouter.ContactDetail -> div {
                                +"Welcome to the Home Page"
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
        modules(routerModule, loginModule)
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
        PrintModule,
        ChartModule,
        TabulatorModule,
        MapsModule,
        CoreModule,
    )
}
