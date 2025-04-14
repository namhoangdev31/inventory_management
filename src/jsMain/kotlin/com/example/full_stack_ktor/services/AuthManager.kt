package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.LoginRequest
import com.example.full_stack_ktor.model.LoginResponse
import io.kvision.remote.getService
import org.w3c.fetch.RequestInit

object AuthManager {
    private val authService = getService<IAuthService>(
        requestFilter = null as (suspend RequestInit.() -> Unit)?
    )

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return authService.login(loginRequest)
    }

    suspend fun register(username: String, password: String): String {
        return authService.register(username, password)
    }
}