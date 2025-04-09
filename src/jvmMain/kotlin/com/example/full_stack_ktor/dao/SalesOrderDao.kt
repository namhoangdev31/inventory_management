package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.SalesOrderEntity

interface SalesOrderDao {
	fun getAll(): List<SalesOrderEntity>
}
