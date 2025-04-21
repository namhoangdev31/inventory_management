package com.example.full_stack_ktor.ui.super_admin.viewmodel

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

class SuperAdminEventHandler : EventHandler<
        SuperAdminContract.Inputs,
        SuperAdminContract.Events,
        SuperAdminContract.State> {
    override suspend fun EventHandlerScope<
            SuperAdminContract.Inputs,
            SuperAdminContract.Events,
            SuperAdminContract.State>.handleEvent(
        event: SuperAdminContract.Events
    ): Unit = when (event) {
        is SuperAdminContract.Events.NavigateUp -> {

        }
        is SuperAdminContract.Events.SuperAdminContract -> {

        }
        is SuperAdminContract.Events.SubmitFailure -> {

        }
        is SuperAdminContract.Events.SubmitSuccess -> {

        }
        is SuperAdminContract.Events.ShowError -> {

        }
        is SuperAdminContract.Events.ShowLoading -> {

        }
        is SuperAdminContract.Events.ShowSuccess -> {

        }
    }
}
