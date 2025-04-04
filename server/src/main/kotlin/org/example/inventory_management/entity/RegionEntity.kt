package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class RegionEntity(
    val id: Int? = null,
    val name: String,
    val description: String? = null
)
