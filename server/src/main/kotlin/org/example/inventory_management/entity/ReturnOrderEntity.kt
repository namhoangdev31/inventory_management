package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class ReturnOrderEntity(
	val salesOrderId: Int?,
	val customerId: Int?,
	val returnDate: String,
	val reason: String?,
	val status: String = "pending",
)
