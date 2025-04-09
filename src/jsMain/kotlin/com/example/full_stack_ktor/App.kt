package com.example.full_stack_ktor

import com.example.full_stack_ktor.views.*
import com.example.full_stack_ktor.views.articles.article
import com.example.full_stack_ktor.views.shared.headerNav
import com.example.full_stack_ktor.views.users.*
import io.kvision.*
import io.kvision.html.header
import io.kvision.html.main
import io.kvision.pace.Pace
import io.kvision.pace.PaceOptions
import io.kvision.panel.ContainerType
import io.kvision.panel.root
import io.kvision.routing.Routing
import io.kvision.state.bind
import com.example.full_stack_ktor.views.shared.footer
import io.kvision.routing.Strategy

class App : Application() {

    override fun start() {
        Routing.init(useHash = false , strategy = Strategy.ALL)
        Pace.init(require("pace-progressbar/themes/green/pace-theme-bounce.css"))
        Pace.setOptions(PaceOptions(manual = true))
        ConduitManager.initialize()
        root("kvapp", containerType = ContainerType.NONE, addRow = false) {
            header().bind(ConduitManager.conduitStore) { state ->
                headerNav(state)
            }
            main().bind(ConduitManager.conduitStore) { state ->
                if (!state.appLoading) {
                    when (state.view) {
                        View.HOME -> {
                            homePage(state)
                        }
                        View.ARTICLE -> {
                            article(state)
                        }
                        View.PROFILE -> {
                            profilePage(state)
                        }
                        View.LOGIN -> {
                            loginPage(state)
                        }
                        View.REGISTER -> {
                            registerPage(state)
                        }
                        View.EDITOR -> {
                            editorPage(state)
                        }
                        View.SETTINGS -> {
                            settingsPage(state)
                        }
                    }
                }
            }
            footer()
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
        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        MapsModule,
        CoreModule,
    )
}
