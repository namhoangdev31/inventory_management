package org.example.inventory_management.dao

import org.example.inventory_management.entity.LocationEntity

interface LocationDao {
	fun getAll(): List<LocationEntity>
}
