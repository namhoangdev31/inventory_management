package com.example.full_stack_ktor.ui.login_page.repository

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.repository.BallastRepository
import com.copperleaf.ballast.repository.bus.EventBus
import com.copperleaf.ballast.repository.cache.Cached
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginRepositoryImpl(
	coroutineScope: CoroutineScope,
	eventBus: EventBus,
	configBuilder: BallastViewModelConfiguration.Builder,
) : BallastRepository<
		LoginRepositoryContract.Inputs,
		LoginRepositoryContract.State>(
	coroutineScope = coroutineScope,
	eventBus = eventBus,
	config = configBuilder
		.apply {
			this.inputHandler = LoginRepositoryInputHandler(eventBus)
			this.initialState = LoginRepositoryContract.State()
			this.name = "Login Repository"
		}
		.build(),
), LoginRepository {
	override fun clearAllCaches() {
		trySend(LoginRepositoryContract.Inputs.ClearCaches)
	}
	
	override fun getDataList(refreshCache: Boolean): Flow<Cached<List<String>>> {
		trySend(LoginRepositoryContract.Inputs.Initialize)
		trySend(LoginRepositoryContract.Inputs.RefreshDataList(refreshCache))
		return observeStates()
			.map { it.dataList }
	}
}
