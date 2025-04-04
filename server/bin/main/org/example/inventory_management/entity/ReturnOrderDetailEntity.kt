package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class ReturnOrderDetailEntity(
	val returnOrderId: Int,
	val productId: Int,
	val quantity: Int,
)
