package org.example.inventory_management.dao

import org.example.inventory_management.entity.SalesOrderDetailEntity

interface SalesOrderDetailDao {
	fun getAll(): List<SalesOrderDetailEntity>
}
