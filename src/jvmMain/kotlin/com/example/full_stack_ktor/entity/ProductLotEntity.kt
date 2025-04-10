package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class ProductLotEntity(
	val productId: Int,
	val lotNumber: String,
	val quantity: Int,
	val expirationDate: String?,
	val receivedDate: String?
)
