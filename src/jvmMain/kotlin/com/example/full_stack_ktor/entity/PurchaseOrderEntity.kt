package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseOrderEntity(
	val supplierId: Int,
	val orderDate: String,
	val expectedArrival: String?,
	val totalAmount: Double?,
	val status: String = "pending",
)
