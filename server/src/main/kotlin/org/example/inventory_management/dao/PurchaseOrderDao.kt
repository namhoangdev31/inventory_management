package org.example.inventory_management.dao

import org.example.inventory_management.entity.PurchaseOrderEntity

interface PurchaseOrderDao {
	fun getAll(): List<PurchaseOrderEntity>
}
