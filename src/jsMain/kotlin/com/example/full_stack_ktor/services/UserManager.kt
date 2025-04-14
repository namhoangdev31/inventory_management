package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.User
import io.kvision.remote.getService
import org.w3c.fetch.RequestInit

object UserManager {
    private val userService = getService<IUserService>(
        requestFilter = null as (suspend RequestInit.() -> Unit)?
    )

    suspend fun user(): User {
        return userService.user()
    }
    suspend fun settings(
        image: String?,
        username: String?,
        bio: String?,
        email: String?,
        password: String?
    ): User {
        return userService.settings(image, username, bio, email, password)
    }
    suspend fun profile(username: String): User {
        return userService.profile(username)
    }
    suspend fun profileFollow(username: String, follow: Boolean = true): User {
        return userService.profileFollow(username, follow)
    }
}