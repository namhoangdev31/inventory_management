package com.example.full_stack_ktor

import io.kvision.annotations.KVService

@KVService
interface IAuthService {
    suspend fun login(username: String, password: String): String
    suspend fun register(username: String, password: String): String
}