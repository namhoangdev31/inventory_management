package com.example.full_stack_ktor.ui.super_admin.viewmodel

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import kotlinx.coroutines.delay

class SuperAdminInputHandler : InputHandler<
        SuperAdminContract.Inputs,
        SuperAdminContract.Events,
        SuperAdminContract.State> {
    override suspend fun InputHandlerScope<
            SuperAdminContract.Inputs,
            SuperAdminContract.Events,
            SuperAdminContract.State>.handleInput(
        input: SuperAdminContract.Inputs
    ): Unit = when (input) {
        is SuperAdminContract.Inputs.Initialize -> {
            updateState { it.copy(loading = true) }
            delay(1000)
            updateState { it.copy(loading = false) }
        }

        is SuperAdminContract.Inputs.GoBack -> {
            postEvent(SuperAdminContract.Events.NavigateUp)
        }

        is SuperAdminContract.Inputs.Login -> {

        }

        is SuperAdminContract.Inputs.GoForward -> {

        }

        is SuperAdminContract.Inputs.UpdatePassword -> {

        }

        is SuperAdminContract.Inputs.UpdateUsername -> {

        }
    }
}
