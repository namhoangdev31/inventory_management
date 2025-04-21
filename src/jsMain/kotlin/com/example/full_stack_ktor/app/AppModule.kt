package com.example.full_stack_ktor.app

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.core.JsConsoleLogger
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.bus.EventBusImpl
import com.example.full_stack_ktor.AppScope
import com.example.full_stack_ktor.ui.cms.login.loginCMSViewModel
import com.example.full_stack_ktor.ui.login_page.viewmodel.loginModule
import com.example.full_stack_ktor.ui.register_page.registerModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initializeKoin() {
	val appModule = module {
		single { AppScope }
		
		factory {
			BallastViewModelConfiguration.Builder().apply {
				logger = { message -> JsConsoleLogger(message) }
			}
		}
		single<EventBus> { EventBusImpl() }
		includes(
			routerModule,
			loginModule,
			registerModule,
			loginCMSViewModel
		)
	}
	
	startKoin {
		modules(appModule)
	}
}
