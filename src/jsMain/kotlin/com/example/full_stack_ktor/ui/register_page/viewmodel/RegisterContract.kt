package com.example.full_stack_ktor.ui.register_page.viewmodel

object RegisterContract {
	data class State(
		val loading: Boolean = false,
	)
	
	sealed interface Inputs {
		object Initialize : Inputs
		object GoBack : Inputs
	}
	
	sealed interface Events {
		object NavigateUp : Events
	}
}
