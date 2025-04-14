package com.example.full_stack_ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse (
    val statusMessage: String,
    val error: String? = null,
    val tokenAccess: String? = null
)