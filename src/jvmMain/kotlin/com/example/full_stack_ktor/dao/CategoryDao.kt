package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.CategoryEntity
import com.example.full_stack_ktor.table.inventory_management.CategoryTable
import org.jetbrains.exposed.sql.Op

interface CategoryDao {
	suspend fun findCategoryByName(name: String): CategoryEntity?
	suspend fun insertCategory(category: CategoryEntity): CategoryEntity
	suspend fun deleteCategory(id: Int): Boolean
	suspend fun getAll(): List<CategoryEntity>
	suspend fun getAllWithCondition(condition: (CategoryTable) -> Op<Boolean>): List<CategoryEntity>
}
