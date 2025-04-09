package com.example.full_stack_ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val statusMessage: String,
    val error: String
)
