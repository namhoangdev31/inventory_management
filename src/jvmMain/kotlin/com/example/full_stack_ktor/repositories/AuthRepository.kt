package com.example.full_stack_ktor.repositories

import com.example.full_stack_ktor.models.*

interface AuthRepository {
    suspend fun login(postParam: AuthRequest): AuthResponse
    suspend fun register(postParam: RegisterRequest): RegisterResponse
}


