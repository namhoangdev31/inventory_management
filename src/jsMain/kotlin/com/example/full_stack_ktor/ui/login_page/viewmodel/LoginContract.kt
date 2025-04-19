package com.example.full_stack_ktor.ui.login_page.viewmodel

object LoginContract {
	data class State(
		val loading: Boolean = false,
		val email: String = "",
		val password: String = "",
	)
	
	sealed interface Inputs {
		object Initialize : Inputs
		object GoBack : Inputs
		data class UpdateEmail(val email: String) : Inputs
		data class UpdatePassword(val password: String) : Inputs
		data class Submit(val email: String, val password: String) : Inputs
		data class ShowError(val error: String) : Inputs
		data class ShowSuccess(val message: String) : Inputs
		data class ShowLoading(val loading: Boolean) : Inputs
		data class ShowToast(val message: String) : Inputs
		data class ShowSnackbar(val message: String) : Inputs
	}
	
	sealed interface Events {
		object NavigateUp : Events
		data class ShowError(val error: String) : Events
		data class ShowSuccess(val message: String) : Events
		data class ShowLoading(val loading: Boolean) : Events
		data class ShowToast(val message: String) : Events
		data class ShowSnackbar(val message: String) : Events
		data class NavigateTo(val destination: String) : Events
		data class NavigateToWithArgs(val destination: String, val args: Map<String, String>) : Events
		data class ShowDialog(val title: String, val message: String) : Events
		data class ShowBottomSheet(val title: String, val message: String) : Events
	}
}
