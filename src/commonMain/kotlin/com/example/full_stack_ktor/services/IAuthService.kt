package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.LoginRequest
import com.example.full_stack_ktor.model.LoginResponse
import io.kvision.annotations.KVService

@KVService
interface IAuthService {
    suspend fun login(loginRequest: LoginRequest): LoginResponse
    suspend fun register(username: String, password: String): String
}