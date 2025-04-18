package com.example.full_stack_ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiDataResource<T>(
	val data: T,
	val message: String = "Successful!"
)

@Serializable
data class ApiSuccessResponse(
	val message: String
)

@Serializable
data class ApiErrorResponse(val message: String)
