package org.example.inventory_management.repositories

import org.example.inventory_management.models.AuthRequest
import org.example.inventory_management.models.AuthResponse
import org.example.inventory_management.models.RegisterRequest
import org.example.inventory_management.models.RegisterResponse

interface AuthRepository {
    suspend fun login(postParam: AuthRequest): AuthResponse
    suspend fun register(postParam: RegisterRequest): RegisterResponse
}


