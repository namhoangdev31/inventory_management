package com.example.full_stack_ktor.repository.auth

import com.copperleaf.ballast.repository.cache.Cached
import com.example.full_stack_ktor.dto.AuthLoggedInUserDto
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun initialize()
    fun login(accessToken: String, userData: AuthLoggedInUserDto)
    fun logOut()
    fun isLoggedIn(): Flow<Boolean>
}
