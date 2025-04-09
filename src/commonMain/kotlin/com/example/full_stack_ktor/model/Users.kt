package com.example.full_stack_ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int? = null,
    val email: String? = null,
    val token: String? = null,
    val username: String? = null,
    val password: String? = null,
    val bio: String? = null,
    val image: String? = null,
    val following: Boolean? = null
) {
    // Constructor phụ trợ, phục vụ cho các trường hợp không cung cấp đầy đủ dữ liệu
    constructor(
        id: Int?,
        email: String?,
        username: String?,
        password: String?,
        bio: String?,
        image: String?
    ) : this(id, email, null, username, password, bio, image, null)
}
