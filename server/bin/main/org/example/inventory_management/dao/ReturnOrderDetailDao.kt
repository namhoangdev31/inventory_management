package org.example.inventory_management.dao

import org.example.inventory_management.entity.ReturnOrderDetailEntity

interface ReturnOrderDetailDao {
	fun getAll(): List<ReturnOrderDetailEntity>
}
