package org.example.inventory_management.repositories

interface UserRepository {
    suspend fun getUser()
    suspend fun getUserDetails()
    suspend fun updateUser()
    suspend fun deleteUser()
}


