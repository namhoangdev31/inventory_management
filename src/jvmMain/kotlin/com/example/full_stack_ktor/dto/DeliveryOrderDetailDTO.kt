package com.example.full_stack_ktor.dto

import com.example.full_stack_ktor.table.inventory_management.DeliveryOrderDetailTable
import org.jetbrains.exposed.dao.EntityBatchUpdate
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class DeliveryOrderDetailDTO(id: EntityID<Int>) : IntEntity(id)  {
	companion object : IntEntityClass<DeliveryOrderDetailDTO>(DeliveryOrderDetailTable)

	var deliveryOrderId by DeliveryOrderDetailTable.deliveryOrderId
	var productId by DeliveryOrderDetailTable.productId
	var quantity by DeliveryOrderDetailTable.quantity

	override fun flush(batch: EntityBatchUpdate?): Boolean {
		return super.flush(batch)
	}
}
