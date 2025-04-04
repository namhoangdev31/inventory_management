package org.example.inventory_management.entity

import korlibs.time.Date
import korlibs.time.DateTime

data class DeliveryOrderEntity(
	val salesOrderId: Int,
	val deliveryDate: DateTime,
	val deliveryAddress: String?,
	val status : String = "pending",
)
