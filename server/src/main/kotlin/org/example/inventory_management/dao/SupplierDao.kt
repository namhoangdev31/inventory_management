package org.example.inventory_management.dao

import org.example.inventory_management.entity.SupplierEntity

interface SupplierDao {
	fun getAll(): List<SupplierEntity>
}
