package com.example.full_stack_ktor.model

import kotlinx.serialization.SerialName
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
    constructor(
        id: Int?,
        email: String?,
        username: String?,
        password: String?,
        bio: String?,
        image: String?
    ) : this(id, email, null, username, password, bio, image, null)
}

@Serializable
data class AuthLoginRequestDto(
    val email: String,
    val password: String
)

@Serializable
data class AuthLoginResponseDto(
    @SerialName("access_token")
    val accessToken: String,
    val user: AuthLoggedInUserDto
)

@Serializable
data class AuthLoggedInUserDto(
    @SerialName("full_name")
    val fullName: String
)

@Serializable
data class AuthRegisterRequestDto(
    @SerialName("full_name")
    val fullName: String,
    val email: String,
    val password: String
)