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
		is LoginContract.Events.ShowError -> {
			// Handle showing error
		}
		is LoginContract.Events.ShowSuccess -> {
			// Handle showing success
		}
		is LoginContract.Events.ShowLoading -> {
			// Handle showing loading
		}
		is LoginContract.Events.ShowToast -> {
			// Handle showing toast
		}
		is LoginContract.Events.ShowSnackbar -> {
			// Handle showing snackbar
		}
		is LoginContract.Events.NavigateTo -> {
			// Handle navigation
		}
		is LoginContract.Events.NavigateToWithArgs -> {
			// Handle navigation with arguments
		}
		is LoginContract.Events.ShowDialog -> {
			// Handle showing dialog
		}
		is LoginContract.Events.ShowBottomSheet -> {
			// Handle showing bottom sheet
		}
	}
}
