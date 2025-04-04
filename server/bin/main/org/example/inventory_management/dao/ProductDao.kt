package org.example.inventory_management.dao

import org.example.inventory_management.entity.ProductEntity

interface ProductDao {
	fun getAll(): List<ProductEntity>
	fun getById(id: Long): ProductEntity?
	fun create(product: ProductEntity): ProductEntity
	fun update(product: ProductEntity): ProductEntity
	fun delete(id: Long): Boolean
}
