package org.example.inventory_management.dao

import org.example.inventory_management.entity.ProductLotEntity

interface ProductLotDao {
	fun getAll(): List<ProductLotEntity>
}
