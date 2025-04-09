package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.DeliveryOrderEntity

interface DeliveryOrderDao {
	suspend fun getAll(): List<DeliveryOrderEntity>
	suspend fun getById(id: Int): DeliveryOrderEntity?
	suspend fun insert(deliveryOrder: DeliveryOrderEntity): DeliveryOrderEntity
	suspend fun update(deliveryOrder: DeliveryOrderEntity): Boolean
	suspend fun delete(id: Int): Boolean
}
