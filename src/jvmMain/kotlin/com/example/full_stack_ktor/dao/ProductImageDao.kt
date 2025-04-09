package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.ProductImageEntity

interface ProductImageDao {
	fun getAll(): List<ProductImageEntity>
}
