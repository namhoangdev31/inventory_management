package org.example.inventory_management.dao

import org.example.inventory_management.entity.WarehouseEntity

interface WarehouseDao {
	fun getAll(): List<WarehouseEntity>
}
