package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class WarehouseEntity(
	val warehouseName: String,
	val locationId: Int,
	val capacity: String? = null,
)
