package org.example.inventory_management.models

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val statusMessage: String,
    val error: String
)
