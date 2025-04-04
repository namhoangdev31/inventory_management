package org.example.inventory_management.dao

import org.example.inventory_management.entity.PurchasePaymentEntity

interface PurchasePaymentDao {
	 fun getAll(): List<PurchasePaymentEntity>
}
