package org.example.inventory_management.dto

import org.example.inventory_management.table.inventory_management.SalesOrderDetailTable
import org.example.inventory_management.table.inventory_management.SalesOrderTable
import org.jetbrains.exposed.dao.EntityBatchUpdate
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class SalesOrderDTO(id: EntityID<Int>) : IntEntity(id) {
	companion object : IntEntityClass<SalesOrderDTO>(SalesOrderTable)
	
	var customerId by SalesOrderTable.customerId
	var orderDate by SalesOrderTable.orderDate
	var deliveryDate by SalesOrderTable.deliveryDate
	var totalAmount by SalesOrderTable.totalAmount
	var status by SalesOrderTable.status
	
	override fun flush(batch: EntityBatchUpdate?): Boolean {
		return super.flush(batch)
	}
}
