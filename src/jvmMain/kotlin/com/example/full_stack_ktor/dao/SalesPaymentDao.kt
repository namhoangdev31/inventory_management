package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.SalesPaymentEntity

interface SalesPaymentDao {
	fun getAll(): List<SalesPaymentEntity>
}
