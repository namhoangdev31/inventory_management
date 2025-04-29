package com.example.full_stack_ktor.ui.cms.pages.repository

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.repository.BallastRepository
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.cache.Cached
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PagesRepositoryImpl(
	coroutineScope: CoroutineScope,
	eventBus: EventBus,
	configBuilder: BallastViewModelConfiguration.Builder,
) : BallastRepository<
		PagesRepositoryContract.Inputs,
		PagesRepositoryContract.State>(
	coroutineScope = coroutineScope,
	eventBus = eventBus,
	config = configBuilder
		.apply {
			this.inputHandler = PagesRepositoryInputHandler(eventBus)
			this.initialState = PagesRepositoryContract.State()
			this.name = "Pages Repository"
		}
		.build(),
), PagesRepository {
	override fun clearAllCaches() {
		trySend(PagesRepositoryContract.Inputs.ClearCaches)
	}
	
	override fun getDataList(refreshCache: Boolean): Flow<Cached<List<String>>> {
		trySend(PagesRepositoryContract.Inputs.Initialize)
		trySend(PagesRepositoryContract.Inputs.RefreshDataList(refreshCache))
		return observeStates()
			.map { it.dataList }
	}
}
