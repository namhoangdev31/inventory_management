package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.WarehouseEntity

interface WarehouseDao {
	fun getAll(): List<WarehouseEntity>
}
