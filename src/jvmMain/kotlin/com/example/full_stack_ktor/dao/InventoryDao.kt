package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.InventoryEntity

interface InventoryDao {
	fun getAll(): List<InventoryEntity>
}
