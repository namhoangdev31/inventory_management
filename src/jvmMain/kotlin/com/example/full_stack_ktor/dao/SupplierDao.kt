package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.SupplierEntity

interface SupplierDao {
	fun getAll(): List<SupplierEntity>
}
