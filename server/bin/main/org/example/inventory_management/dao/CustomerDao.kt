package org.example.inventory_management.dao

import org.example.inventory_management.entity.CustomerEntity
import org.example.inventory_management.table.inventory_management.CustomerTable
import org.jetbrains.exposed.sql.Op

interface CustomerDao {
	suspend fun findCustomerByName(name: String): CustomerEntity?
	suspend fun insertCustomer(customer: CustomerEntity): CustomerEntity
	suspend fun deleteCustomer(id: Int): Boolean
	suspend fun getAll(): List<CustomerEntity>
	suspend fun getAllWithCondition(condition: (CustomerTable) -> Op<Boolean>): List<CustomerEntity>
}
