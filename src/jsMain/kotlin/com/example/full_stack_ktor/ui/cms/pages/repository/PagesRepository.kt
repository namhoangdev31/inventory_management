package com.example.full_stack_ktor.ui.cms.pages.repository

import com.copperleaf.ballast.repository.cache.Cached
import kotlinx.coroutines.flow.Flow

interface PagesRepository {
	
	fun clearAllCaches()
	fun getDataList(refreshCache: Boolean = false): Flow<Cached<List<String>>>
	
}
