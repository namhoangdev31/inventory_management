package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.PurchaseOrderEntity

interface PurchaseOrderDao {
	fun getAll(): List<PurchaseOrderEntity>
}
