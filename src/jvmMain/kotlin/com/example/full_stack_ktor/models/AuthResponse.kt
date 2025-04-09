package com.example.full_stack_ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val statusMessage: String,
    val error: String? = null,
    val tokenAccess: String? = null
)


