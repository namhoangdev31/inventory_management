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
		is LoginContract.Inputs.UpdateEmail -> {
			console.log(input.email)
			updateState { it.copy(email = input.email) }
		}
		is LoginContract.Inputs.UpdatePassword -> {
			console.log(input.password)
			updateState { it.copy(password = input.password) }
		}
		is LoginContract.Inputs.Submit -> {
			console.log("Submitting login with email: ${input.email} and password: ${input.password}")
			updateState { it.copy(loading = true) }
			delay(1000)
			updateState { it.copy(loading = false) }
			postEvent(LoginContract.Events.ShowSuccess("Login successful"))
		}
		is LoginContract.Inputs.ShowError -> {
			postEvent(LoginContract.Events.ShowError(input.error))
		}
		is LoginContract.Inputs.ShowSuccess -> {
			postEvent(LoginContract.Events.ShowSuccess(input.message))
		}
		is LoginContract.Inputs.ShowLoading -> {
			updateState { it.copy(loading = input.loading) }
		}
		is LoginContract.Inputs.ShowToast -> {
			postEvent(LoginContract.Events.ShowToast(input.message))
		}
		is LoginContract.Inputs.ShowSnackbar -> {
			postEvent(LoginContract.Events.ShowSnackbar(input.message))
		}
	}
}
