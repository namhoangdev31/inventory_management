package org.example.inventory_management.dao

import org.example.inventory_management.entity.StockTransferEntity

interface StockTransferDao {
	fun getAll(): List<StockTransferEntity>
}
