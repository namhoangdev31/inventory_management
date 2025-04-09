package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.ReturnOrderDetailEntity

interface ReturnOrderDetailDao {
	fun getAll(): List<ReturnOrderDetailEntity>
}
