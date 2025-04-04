package org.example.inventory_management.dao

import org.example.inventory_management.entity.InventoryEntity

interface InventoryDao {
	fun getAll(): List<InventoryEntity>
}
