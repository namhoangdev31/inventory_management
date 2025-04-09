package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.User
import io.kvision.remote.getService

object UserManager {
    private val userService = getService<IUserService>()

    suspend fun login(email: String?, password: String?): User {
        return userService.login(email, password)
    }
    suspend fun register(username: String?, email: String?, password: String?): User {
        return userService.register(username, email, password)
    }
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