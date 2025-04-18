package com.example.full_stack_ktor.ui.register_page.viewmodel

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

class RegisterEventHandler : EventHandler<
		RegisterContract.Inputs,
		RegisterContract.Events,
		RegisterContract.State> {
	override suspend fun EventHandlerScope<
			RegisterContract.Inputs,
			RegisterContract.Events,
			RegisterContract.State>.handleEvent(
		event: RegisterContract.Events
	): Unit = when (event) {
		is RegisterContract.Events.NavigateUp -> {
		
		}
	}
}
