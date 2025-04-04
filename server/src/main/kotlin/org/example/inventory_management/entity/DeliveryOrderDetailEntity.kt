package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryOrderDetailEntity(
	val deliveryOrderId: Int,
	val productId: Int,
	val quantity: Int,
)
