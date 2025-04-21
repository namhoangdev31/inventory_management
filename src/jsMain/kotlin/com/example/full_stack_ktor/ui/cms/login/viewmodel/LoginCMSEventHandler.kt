package com.example.full_stack_ktor.ui.cms.login.viewmodel

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

class LoginCMSEventHandler : EventHandler<
		LoginCMSContract.Inputs,
		LoginCMSContract.Events,
		LoginCMSContract.State> {
	override suspend fun EventHandlerScope<
			LoginCMSContract.Inputs,
			LoginCMSContract.Events,
			LoginCMSContract.State>.handleEvent(
		event: LoginCMSContract.Events
	): Unit = when (event) {
		is LoginCMSContract.Events.NavigateUp -> {
		
		}
	}
}
