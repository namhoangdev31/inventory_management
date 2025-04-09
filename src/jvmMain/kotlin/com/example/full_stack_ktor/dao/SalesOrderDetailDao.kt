package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.SalesOrderDetailEntity

interface SalesOrderDetailDao {
	fun getAll(): List<SalesOrderDetailEntity>
}
