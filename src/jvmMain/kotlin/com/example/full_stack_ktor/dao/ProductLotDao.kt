package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.ProductLotEntity

interface ProductLotDao {
	fun getAll(): List<ProductLotEntity>
}
