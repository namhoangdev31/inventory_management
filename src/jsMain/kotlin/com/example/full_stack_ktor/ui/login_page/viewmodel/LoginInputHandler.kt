package com.example.full_stack_ktor.ui.login_page.viewmodel

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import kotlinx.coroutines.delay

class LoginInputHandler : InputHandler<
		LoginContract.Inputs,
		LoginContract.Events,
		LoginContract.State> {
	override suspend fun InputHandlerScope<
			LoginContract.Inputs,
			LoginContract.Events,
			LoginContract.State>.handleInput(
		input: LoginContract.Inputs
	): Unit = when (input) {
		is LoginContract.Inputs.Initialize -> {
			updateState { it.copy(loading = true) }
			delay(1000)
			updateState { it.copy(loading = false) }
		}
		
		is LoginContract.Inputs.GoBack -> {
			postEvent(LoginContract.Events.NavigateUp)
		}
	}
}
