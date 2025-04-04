package org.example.inventory_management.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val statusMessage: String,
    val error: String? = null,
    val tokenAccess: String? = null
)


