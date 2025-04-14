package com.example.full_stack_ktor

import com.example.full_stack_ktor.app.layout.shared.appHeader.appHeader
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
import com.example.full_stack_ktor.repository.auth.AuthRepository
import io.kvision.BootstrapCssModule
import io.kvision.BootstrapIconsModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapUploadModule
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

val AppScope = CoroutineScope(window.asCoroutineDispatcher())

class App : Application(), KoinComponent {

    init {
        io.kvision.require("css/auth.css")
        io.kvision.require("css/dashboard.css")
        io.kvision.require("css/kvapp.css")
    }

    override fun start(state: Map<String, Any>) {
        val root = root("kvapp") {
            val router by inject<AppRouterViewModel>()
            val authRepo by inject<AuthRepository>()

            div().bind(router) { appRouterState ->
                val routerState = appRouterState.backstack

                appHeader()

                routerState.renderCurrentDestination(
                    route = { appRouter ->
                        when (appRouter) {
                            AppRouter.Home -> {
                                landingPage()
                            }
                            AppRouter.Login -> {
                                loginPage()
                            }
                            AppRouter.Signup -> {
                                signupPage()
                            }
                            AppRouter.ContactList -> {
                                contactListPage()
                            }
                            AppRouter.ContactAdd -> {
                                contactAddPage()
                            }
                            AppRouter.ContactDetail -> {
                                val contactUid by stringPath("uid")
                                contactDetailPage(contactUid)
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

            // Initialize Auth Repo
            authRepo.initialize()
        }
    }
}

fun main() {
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
        PrintModule,
        BootstrapCssModule,
        BootstrapUploadModule,

        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        MapsModule,
        CoreModule,
    )
}
