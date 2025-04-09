package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.ProductEntity

interface ProductDao {
	fun getAll(): List<ProductEntity>
	fun getById(id: Long): ProductEntity?
	fun create(product: ProductEntity): ProductEntity
	fun update(product: ProductEntity): ProductEntity
	fun delete(id: Long): Boolean
}
