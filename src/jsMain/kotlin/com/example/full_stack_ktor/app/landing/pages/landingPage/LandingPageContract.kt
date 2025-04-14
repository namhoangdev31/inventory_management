package com.example.full_stack_ktor.app.landing.pages.landingPage

object LandingPageContract {
    data class State(
        val loading: Boolean = false,
    )

    sealed class Inputs {
        object Initialize : Inputs()
        object NavigateToContactListPage : Inputs()
    }

    sealed class Events {
        object NavigateToContactListPage : Events()
    }
}
