package com.example.full_stack_ktor.app

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.core.JsConsoleLogger
import com.copperleaf.ballast.core.LoggingInterceptor
import com.copperleaf.ballast.plusAssign
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.bus.EventBusImpl
import com.example.full_stack_ktor.AppScope
import com.example.full_stack_ktor.api.endpointModule
import com.example.full_stack_ktor.app.auth.pages.authModule
import com.example.full_stack_ktor.app.contacts.pages.contactModule
import com.example.full_stack_ktor.app.landing.pages.landingPage.landingPageModule
import com.example.full_stack_ktor.app.layout.appLayoutModule
import com.example.full_stack_ktor.app.layout.shared.sharedComponentsModule
import com.example.full_stack_ktor.repository.repositoryModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initializeKoin() {
    val appModule = module {
        // Global Coroutine Scope (JavaScript is single-threaded, so...)
        single { AppScope }

        // Ballast Configuration
        factory {
            BallastViewModelConfiguration.Builder().apply {
                this += LoggingInterceptor()
                logger = { JsConsoleLogger(it) }
            }
        }

        // Ballast EventBus for Repositories
        single<EventBus> { EventBusImpl() }

        // Import all modules...
        includes(
            endpointModule,
            routerModule,
            repositoryModule,
            sharedComponentsModule,
            appLayoutModule,
            landingPageModule,
            authModule,
            contactModule
        )
    }

    startKoin {
        modules(appModule)
    }
}