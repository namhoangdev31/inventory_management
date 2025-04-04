package org.example.inventory_management.dao

import org.example.inventory_management.entity.RoleEntity

interface RoleDao {
	fun getAll(): List<RoleEntity>
}
