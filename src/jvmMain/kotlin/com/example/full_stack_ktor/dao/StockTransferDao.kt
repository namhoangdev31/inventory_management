package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.StockTransferEntity

interface StockTransferDao {
	fun getAll(): List<StockTransferEntity>
}
