package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.PurchaseOrderDetailEntity

interface PurchaseOrderDetailDao {
	fun getAll(): List<PurchaseOrderDetailEntity>
}
