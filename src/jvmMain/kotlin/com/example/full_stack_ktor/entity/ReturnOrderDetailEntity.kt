package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class ReturnOrderDetailEntity(
	val returnOrderId: Int,
	val productId: Int,
	val quantity: Int,
)
