package com.example.full_stack_ktor.ui.register_page.viewmodel

import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope

class RegisterViewModel(
	coroutineScope: CoroutineScope,
	configBuilder: BallastViewModelConfiguration.Builder,
) : BasicViewModel<
		RegisterContract.Inputs,
		RegisterContract.Events,
		RegisterContract.State>(
	coroutineScope = coroutineScope,
	config = configBuilder
		.withViewModel(
			inputHandler = RegisterInputHandler(),
			initialState = RegisterContract.State(),
			name = "Register",
		)
		.build(),
	eventHandler = RegisterEventHandler(),
)
