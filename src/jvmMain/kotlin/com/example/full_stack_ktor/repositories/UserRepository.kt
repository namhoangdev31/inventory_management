package com.example.full_stack_ktor.repositories

interface UserRepository {
    suspend fun getUser()
    suspend fun getUserDetails()
    suspend fun updateUser()
    suspend fun deleteUser()
}


