@file:UseContextualSerialization(LocalDateTime::class)

package com.example.full_stack_ktor.model

import io.kvision.types.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization

@Serializable
data class PagesModel(
    val id: String,
    val pageName: String,
    val pageSlug: String,
    val updateAt: Double,
)
