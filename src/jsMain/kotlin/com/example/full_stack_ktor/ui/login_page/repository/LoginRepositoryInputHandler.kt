package com.example.full_stack_ktor.ui.login_page.repository

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import com.copperleaf.ballast.observeFlows
import com.copperleaf.ballast.postInput
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.bus.observeInputsFromBus
import com.copperleaf.ballast.repository.cache.fetchWithCache

class LoginRepositoryInputHandler(
	private val eventBus: EventBus,
) : InputHandler<
		LoginRepositoryContract.Inputs,
		Any,
		LoginRepositoryContract.State> {
	override suspend fun InputHandlerScope<
			LoginRepositoryContract.Inputs,
			Any,
			LoginRepositoryContract.State>.handleInput(
		input: LoginRepositoryContract.Inputs
	): Unit = when (input) {
		is LoginRepositoryContract.Inputs.ClearCaches -> {
			updateState { LoginRepositoryContract.State() }
		}
		
		is LoginRepositoryContract.Inputs.Initialize -> {
			val previousState = getCurrentState()
			
			if (!previousState.initialized) {
				updateState { it.copy(initialized = true) }
				// start observing flows here
				logger.debug("initializing")
				observeFlows(
					key = "Observe account changes",
					eventBus
						.observeInputsFromBus<LoginRepositoryContract.Inputs>(),
				)
			} else {
				logger.debug("already initialized")
				noOp()
			}
		}
		
		is LoginRepositoryContract.Inputs.RefreshAllCaches -> {
			// then refresh all the caches in this repository
			val currentState = getCurrentState()
			if (currentState.dataListInitialized) {
				postInput(LoginRepositoryContract.Inputs.RefreshDataList(true))
			}
			
			Unit
		}
		
		is LoginRepositoryContract.Inputs.DataListUpdated -> {
			updateState { it.copy(dataList = input.dataList) }
		}
		
		is LoginRepositoryContract.Inputs.RefreshDataList -> {
			updateState { it.copy(dataListInitialized = true) }
			fetchWithCache(
				input = input,
				forceRefresh = input.forceRefresh,
				getValue = { it.dataList },
				updateState = { LoginRepositoryContract.Inputs.DataListUpdated(it) },
				doFetch = { TODO() },
			)
		}
	}
}
