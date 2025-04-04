package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class ProductImageEntity(
	val productId: Int,
	val imageUrl: String,
	val description: String? = null,
	val isPrimary: Boolean = false
)
