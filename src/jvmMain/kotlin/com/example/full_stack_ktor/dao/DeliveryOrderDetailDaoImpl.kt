package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.DeliveryOrderDetailEntity

class DeliveryOrderDetailDaoImpl : DeliveryOrderDetailDao {
	override suspend fun getAll(): List<DeliveryOrderDetailEntity> {
		TODO("Not yet implemented")
	}
	
	override suspend fun getById(id: Int): DeliveryOrderDetailEntity {
		TODO("Not yet implemented")
	}
	
	override suspend fun insert(deliveryOrderDetail: DeliveryOrderDetailEntity): DeliveryOrderDetailEntity {
		TODO("Not yet implemented")
	}
	
	override suspend fun update(deliveryOrderDetail: DeliveryOrderDetailEntity): Boolean {
		TODO("Not yet implemented")
	}
	
	override suspend fun delete(id: Int): Boolean {
		TODO("Not yet implemented")
	}
}
