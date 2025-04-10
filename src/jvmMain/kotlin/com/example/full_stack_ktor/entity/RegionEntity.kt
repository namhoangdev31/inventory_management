package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class RegionEntity(
    val id: Int? = null,
    val name: String,
    val description: String? = null
)
