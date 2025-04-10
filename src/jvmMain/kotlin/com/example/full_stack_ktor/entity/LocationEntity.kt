package com.example.full_stack_ktor.entity

import kotlinx.serialization.Serializable

@Serializable
data class LocationEntity(
	val regionId: Int,
	val locationName: String,
	val address: String,
	val city: String,
	val country: String,
)
