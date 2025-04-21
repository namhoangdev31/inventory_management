package com.example.full_stack_ktor.ui.cms.login.viewmodel

object LoginCMSContract {
	data class State(
		val loading: Boolean = false,
		val error: String? = null,
		val success: String? = null,
		val username: String = "",
		val password: String = "",
	)
	
	sealed interface Inputs {
		object Initialize : Inputs
		object GoBack : Inputs
		data class UpdateUsername(val username: String) : Inputs
		data class UpdatePassword(val password: String) : Inputs
		object Submit : Inputs
	}
	
	sealed interface Events {
		object NavigateUp : Events
		object ShowError : Events
		object ShowSuccess : Events
		object ShowLoading : Events
		object SubmitSuccess : Events
		object SubmitFailure : Events
	}
}
