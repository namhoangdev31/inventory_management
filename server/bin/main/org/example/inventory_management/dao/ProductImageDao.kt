package org.example.inventory_management.dao

import org.example.inventory_management.entity.ProductImageEntity

interface ProductImageDao {
	fun getAll(): List<ProductImageEntity>
}
