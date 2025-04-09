package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class SalesPaymentEntity(
	val salesOrderId: Int,
	val paymentDate: String,
	val amount: Double,
	val paymentMethod: String?,
	val status: String = "completed"
)
