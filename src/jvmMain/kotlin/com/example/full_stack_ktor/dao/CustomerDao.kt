package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.CustomerEntity
import com.example.full_stack_ktor.table.inventory_management.CustomerTable
import org.jetbrains.exposed.sql.Op

interface CustomerDao {
	suspend fun findCustomerByName(name: String): CustomerEntity?
	suspend fun insertCustomer(customer: CustomerEntity): CustomerEntity
	suspend fun deleteCustomer(id: Int): Boolean
	suspend fun getAll(): List<CustomerEntity>
	suspend fun getAllWithCondition(condition: (CustomerTable) -> Op<Boolean>): List<CustomerEntity>
}
