package com.example.full_stack_ktor.ui.cms.login

import com.example.full_stack_ktor.app.AppRouterViewModel
import com.example.full_stack_ktor.ui.cms.login.viewmodel.LoginCMSViewModel
import io.kvision.core.Container
import io.kvision.html.*
import io.kvision.state.bind
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import kotlin.getValue

fun Container.loginCMSAdminPage(): KoinComponent = object : KoinComponent {
	val router by inject<AppRouterViewModel>()
	
	init {
		div(className = "flex flex-col items-center justify-center h-screen").bind(router) { appRouterState ->
			h1(className = "text-center text-primary text-32") {
				+"Login CMS"
			}
		}
	}
}

val loginCMSViewModel = module {
	single { LoginCMSViewModel(get(), get()) }
}