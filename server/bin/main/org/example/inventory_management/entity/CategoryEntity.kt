package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
	val id: Int? = null,
	val categoryName: String,
	val description: String? = null
)
