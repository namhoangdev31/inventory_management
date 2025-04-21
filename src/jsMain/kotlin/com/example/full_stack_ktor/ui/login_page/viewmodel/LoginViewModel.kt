package com.example.full_stack_ktor.ui.login_page.viewmodel

import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

class LoginViewModel(
	coroutineScope: CoroutineScope,
	configBuilder: BallastViewModelConfiguration.Builder,
) : BasicViewModel<
		LoginContract.Inputs,
		LoginContract.Events,
		LoginContract.State>(
	coroutineScope = coroutineScope,
	config = configBuilder
		.withViewModel(
			inputHandler = LoginInputHandler(),
			initialState = LoginContract.State(),
			name = "Login",
		)
		.build(),
	eventHandler = LoginEventHandler(),
)