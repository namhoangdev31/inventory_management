package com.example.full_stack_ktor.ui.super_admin.viewmodel

import com.example.full_stack_ktor.ui.cms.login.viewmodel.LoginCMSContract

object SuperAdminContract {
    data class State(
        val loading: Boolean = false,
        val username: String = "",
        val password: String = "",
    )

    sealed interface Inputs {
        object Initialize : Inputs
        object GoBack : Inputs
        object GoForward : Inputs
        object Login : Inputs
        data class UpdateUsername(val username: String): Inputs
        data class UpdatePassword(val password: String): Inputs
    }

    sealed interface Events {
        object NavigateUp : Events
        object SuperAdminContract : Events
        object ShowError : Events
        object ShowSuccess : Events
        object ShowLoading : Events
        object SubmitSuccess : Events
        object SubmitFailure : Events
    }
}
