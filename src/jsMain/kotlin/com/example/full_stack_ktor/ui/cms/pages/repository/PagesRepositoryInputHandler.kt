package com.example.full_stack_ktor.ui.cms.pages.repository

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import com.copperleaf.ballast.observeFlows
import com.copperleaf.ballast.postInput
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.bus.observeInputsFromBus
import com.copperleaf.ballast.repository.cache.fetchWithCache

class PagesRepositoryInputHandler(
	private val eventBus: EventBus,
) : InputHandler<
		PagesRepositoryContract.Inputs,
		Any,
		PagesRepositoryContract.State> {
	override suspend fun InputHandlerScope<
			PagesRepositoryContract.Inputs,
			Any,
			PagesRepositoryContract.State>.handleInput(
		input: PagesRepositoryContract.Inputs
	): Unit = when (input) {
		is PagesRepositoryContract.Inputs.ClearCaches -> {
			updateState { PagesRepositoryContract.State() }
		}
		
		is PagesRepositoryContract.Inputs.Initialize -> {
			val previousState = getCurrentState()
			
			if (!previousState.initialized) {
				updateState { it.copy(initialized = true) }
				// start observing flows here
				logger.debug("initializing")
				observeFlows(
					key = "Observe account changes",
					eventBus
						.observeInputsFromBus<PagesRepositoryContract.Inputs>(),
				)
			} else {
				logger.debug("already initialized")
				noOp()
			}
		}
		
		is PagesRepositoryContract.Inputs.RefreshAllCaches -> {
			// then refresh all the caches in this repository
			val currentState = getCurrentState()
			if (currentState.dataListInitialized) {
				postInput(PagesRepositoryContract.Inputs.RefreshDataList(true))
			}
			
			Unit
		}
		
		is PagesRepositoryContract.Inputs.DataListUpdated -> {
			updateState { it.copy(dataList = input.dataList) }
		}
		
		is PagesRepositoryContract.Inputs.RefreshDataList -> {
			updateState { it.copy(dataListInitialized = true) }
			fetchWithCache(
				input = input,
				forceRefresh = input.forceRefresh,
				getValue = { it.dataList },
				updateState = { PagesRepositoryContract.Inputs.DataListUpdated(it) },
				doFetch = { TODO() },
			)
		}
	}
}
