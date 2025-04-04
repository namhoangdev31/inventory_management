package org.example.inventory_management.dao

import org.example.inventory_management.entity.SalesOrderEntity

interface SalesOrderDao {
	fun getAll(): List<SalesOrderEntity>
}
