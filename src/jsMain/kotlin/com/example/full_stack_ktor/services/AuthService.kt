package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.IAuthService

actual class AuthService:IAuthService {
    override suspend fun login(username: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun register(username: String, password: String): String {
        TODO("Not yet implemented")
    }
}