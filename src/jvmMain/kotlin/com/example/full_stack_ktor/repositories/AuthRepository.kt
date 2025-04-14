package com.example.full_stack_ktor.repositories

import com.example.full_stack_ktor.model.LoginRequest
import com.example.full_stack_ktor.model.LoginResponse
import com.example.full_stack_ktor.models.*

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): LoginResponse
    suspend fun register(postParam: RegisterRequest): RegisterResponse
}


