package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
	val id: Int? = null,
	val categoryName: String,
	val description: String? = null
)
