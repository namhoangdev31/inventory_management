package com.example.full_stack_ktor.ui.login_page.repository

import com.copperleaf.ballast.repository.cache.Cached
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
	
	fun clearAllCaches()
	fun getDataList(refreshCache: Boolean = false): Flow<Cached<List<String>>>
	
}
