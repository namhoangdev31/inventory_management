package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.EmployeeEntity

interface EmployeeDao {
	fun getAllEmployees(): List<EmployeeEntity>
	fun getEmployeeById(id: Int): EmployeeEntity?
	fun addEmployee(employee: EmployeeEntity): EmployeeEntity
	fun updateEmployee(employee: EmployeeEntity): Boolean
	fun deleteEmployee(id: Int): Boolean
}
