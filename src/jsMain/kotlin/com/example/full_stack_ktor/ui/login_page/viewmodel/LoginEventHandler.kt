package com.example.full_stack_ktor.ui.login_page.viewmodel

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

class LoginEventHandler : EventHandler<
		LoginContract.Inputs,
		LoginContract.Events,
		LoginContract.State> {
	override suspend fun EventHandlerScope<
			LoginContract.Inputs,
			LoginContract.Events,
			LoginContract.State>.handleEvent(
		event: LoginContract.Events
	): Unit = when (event) {
		is LoginContract.Events.NavigateUp -> {
		
		}
	}
}
