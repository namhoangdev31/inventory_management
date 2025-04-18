package com.example.full_stack_ktor.ui.register_page.viewmodel

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import kotlinx.coroutines.delay

class RegisterInputHandler : InputHandler<
		RegisterContract.Inputs,
		RegisterContract.Events,
		RegisterContract.State> {
	override suspend fun InputHandlerScope<
			RegisterContract.Inputs,
			RegisterContract.Events,
			RegisterContract.State>.handleInput(
		input: RegisterContract.Inputs
	): Unit = when (input) {
		is RegisterContract.Inputs.Initialize -> {
			updateState { it.copy(loading = true) }
			delay(1000)
			updateState { it.copy(loading = false) }
		}
		
		is RegisterContract.Inputs.GoBack -> {
			postEvent(RegisterContract.Events.NavigateUp)
		}
	}
}
