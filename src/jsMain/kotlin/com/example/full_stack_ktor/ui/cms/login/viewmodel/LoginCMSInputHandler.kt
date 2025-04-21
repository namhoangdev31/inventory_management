package com.example.full_stack_ktor.ui.cms.login.viewmodel

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import kotlinx.coroutines.delay

class LoginCMSInputHandler : InputHandler<
		LoginCMSContract.Inputs,
		LoginCMSContract.Events,
		LoginCMSContract.State> {
	override suspend fun InputHandlerScope<
			LoginCMSContract.Inputs,
			LoginCMSContract.Events,
			LoginCMSContract.State>.handleInput(
		input: LoginCMSContract.Inputs
	): Unit = when (input) {
		is LoginCMSContract.Inputs.Initialize -> {
			updateState { it.copy(loading = true) }
			delay(1000)
			updateState { it.copy(loading = false) }
		}
		
		is LoginCMSContract.Inputs.GoBack -> {
			postEvent(LoginCMSContract.Events.NavigateUp)
		}
	}
}
