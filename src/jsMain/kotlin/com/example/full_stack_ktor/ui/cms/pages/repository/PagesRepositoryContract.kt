package com.example.full_stack_ktor.ui.cms.pages.repository

import com.copperleaf.ballast.repository.cache.Cached

object PagesRepositoryContract {
	data class State(
		val initialized: Boolean = false,
		val dataListInitialized: Boolean = false,
		val dataList: Cached<List<String>> = Cached.NotLoaded(),
	)
	
	sealed interface Inputs {
		object ClearCaches : Inputs
		object Initialize : Inputs
		object RefreshAllCaches : Inputs
		data class RefreshDataList(val forceRefresh: Boolean) : Inputs
		data class DataListUpdated(val dataList: Cached<List<String>>) : Inputs
	}
}
