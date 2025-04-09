package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.PurchasePaymentEntity

interface PurchasePaymentDao {
	 fun getAll(): List<PurchasePaymentEntity>
}
