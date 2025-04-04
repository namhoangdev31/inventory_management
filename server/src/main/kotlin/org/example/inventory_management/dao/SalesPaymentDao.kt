package org.example.inventory_management.dao

import org.example.inventory_management.entity.SalesPaymentEntity

interface SalesPaymentDao {
	fun getAll(): List<SalesPaymentEntity>
}
