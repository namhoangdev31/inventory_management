package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.ReturnOrderEntity

interface ReturnOrderDao {
	fun getAll(): List<ReturnOrderEntity>
}
