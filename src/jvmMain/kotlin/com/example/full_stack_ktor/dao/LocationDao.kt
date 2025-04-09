package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.LocationEntity

interface LocationDao {
	fun getAll(): List<LocationEntity>
}
