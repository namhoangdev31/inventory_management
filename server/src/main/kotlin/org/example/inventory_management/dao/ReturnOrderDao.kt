package org.example.inventory_management.dao

import org.example.inventory_management.entity.ReturnOrderEntity

interface ReturnOrderDao {
	fun getAll(): List<ReturnOrderEntity>
}
