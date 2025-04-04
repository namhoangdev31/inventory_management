package org.example.inventory_management.dao

import org.example.inventory_management.entity.InventoryEntity

interface InventoryTransactionDao {
	fun getAll(): List<InventoryEntity>
}
