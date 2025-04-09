package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.DeliveryOrderEntity

class DeliveryOrderDaoImpl : DeliveryOrderDao {
	override suspend fun getAll(): List<DeliveryOrderEntity> {
		TODO("Not yet implemented")
	}
	
	override suspend fun getById(id: Int): DeliveryOrderEntity? {
		TODO("Not yet implemented")
	}
	
	override suspend fun insert(deliveryOrder: DeliveryOrderEntity): DeliveryOrderEntity {
		TODO("Not yet implemented")
	}
	
	override suspend fun update(deliveryOrder: DeliveryOrderEntity): Boolean {
		TODO("Not yet implemented")
	}
	
	override suspend fun delete(id: Int): Boolean {
		TODO("Not yet implemented")
	}
}
