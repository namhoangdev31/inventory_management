package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.CategoryEntity
import com.example.full_stack_ktor.table.inventory_management.CategoryTable
import org.jetbrains.exposed.sql.Op

class CategoryDaoImpl : CategoryDao {
	override suspend fun findCategoryByName(name: String): CategoryEntity? {
		TODO("Not yet implemented")
	}
	
	override suspend fun insertCategory(category: CategoryEntity): CategoryEntity {
		TODO("Not yet implemented")
	}
	
	override suspend fun deleteCategory(id: Int): Boolean {
		TODO("Not yet implemented")
	}
	
	override suspend fun getAll(): List<CategoryEntity> {
		TODO("Not yet implemented")
	}
	
	override suspend fun getAllWithCondition(condition: (CategoryTable) -> Op<Boolean>): List<CategoryEntity> {
		TODO("Not yet implemented")
	}
}
