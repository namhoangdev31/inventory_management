package org.example.inventory_management.dao

import org.example.inventory_management.entity.PurchaseOrderDetailEntity

interface PurchaseOrderDetailDao {
	fun getAll(): List<PurchaseOrderDetailEntity>
}
