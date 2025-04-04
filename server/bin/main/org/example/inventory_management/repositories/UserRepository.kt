package org.example.inventory_management.repositories

import org.example.inventory_management.dao.UserDao
import org.example.inventory_management.services.UserService

interface UserRepository {
    suspend fun getUser()
    suspend fun getUserDetails()
    suspend fun updateUser()
    suspend fun deleteUser()
}


