package com.example.full_stack_ktor.services

import io.kvision.remote.getService

object AuthManager {
    private val authService: IAuthService = getService<IAuthService>()

    suspend fun login(username: String, password: String): String {
        return authService.login(username, password)
    }

    suspend fun register(username: String, password: String): String {
        return authService.register(username, password)
    }
}