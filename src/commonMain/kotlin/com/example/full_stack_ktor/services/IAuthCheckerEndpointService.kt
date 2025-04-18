package com.example.full_stack_ktor.services


import com.example.full_stack_ktor.model.ApiSuccessResponse
import io.kvision.annotations.KVService

@KVService
interface IAuthCheckerEndpointService {
	suspend fun checkAuth(): Result<ApiSuccessResponse>
}
