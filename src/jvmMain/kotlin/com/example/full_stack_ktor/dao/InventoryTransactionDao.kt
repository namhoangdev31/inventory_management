package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.InventoryEntity

interface InventoryTransactionDao {
	fun getAll(): List<InventoryEntity>
}
