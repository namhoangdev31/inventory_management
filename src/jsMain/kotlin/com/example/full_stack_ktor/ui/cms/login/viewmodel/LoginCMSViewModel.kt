package com.example.full_stack_ktor.ui.cms.login.viewmodel

import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope

class LoginCMSViewModel(
	coroutineScope: CoroutineScope,
	configBuilder: BallastViewModelConfiguration.Builder,
) : BasicViewModel<
		LoginCMSContract.Inputs,
		LoginCMSContract.Events,
		LoginCMSContract.State>(
	coroutineScope = coroutineScope,
	config = configBuilder
		.withViewModel(
			inputHandler = LoginCMSInputHandler(),
			initialState = LoginCMSContract.State(),
			name = "LoginCMS",
		)
		.build(),
	eventHandler = LoginCMSEventHandler(),
)
