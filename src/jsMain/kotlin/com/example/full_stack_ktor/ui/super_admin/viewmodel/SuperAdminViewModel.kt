package com.example.full_stack_ktor.ui.super_admin.viewmodel

import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope

class SuperAdminViewModel(
    coroutineScope: CoroutineScope,
    configBuilder: BallastViewModelConfiguration.Builder,
) : BasicViewModel<
        SuperAdminContract.Inputs,
        SuperAdminContract.Events,
        SuperAdminContract.State>(
    coroutineScope = coroutineScope,
    config = configBuilder
        .withViewModel(
            inputHandler = SuperAdminInputHandler(),
            initialState = SuperAdminContract.State(),
            name = "SuperAdmin",
        )
        .build(),
    eventHandler = SuperAdminEventHandler(),
)