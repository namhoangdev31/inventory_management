package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class SalesOrderEntity(
	val customerId: Int,
	val orderDate: String,
	val status: String,
	val totalAmount: Double,
	val deliveryDate: String,
)
