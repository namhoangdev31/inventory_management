package org.example.inventory_management.entity

import kotlinx.serialization.Serializable

@Serializable
data class WarehouseEntity(
	val warehouseName: String,
	val locationId: Int,
	val capacity: String? = null,
)
