package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.RoleEntity

interface RoleDao {
	fun getAll(): List<RoleEntity>
}
