package com.example.full_stack_ktor

import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import com.example.full_stack_ktor.ui.cms.admin.adminCmsPage
import com.example.full_stack_ktor.ui.home_page.presentation.homePage
import com.example.full_stack_ktor.ui.login_page.presentation.loginPage
import com.example.full_stack_ktor.ui.login_page.viewmodel.loginModule
import com.example.full_stack_ktor.ui.register_page.presentation.registerPage
import com.example.full_stack_ktor.ui.register_page.registerModule
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
                            AppRouter.Root -> homePage()
                            AppRouter.Home -> homePage()
                            AppRouter.Login -> loginPage()
                            AppRouter.Signup -> registerPage()
                            AppRouter.About ->  div { +"About Page" }
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

fun main() {
    startKoin {
        modules(routerModule, loginModule , registerModule)
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
