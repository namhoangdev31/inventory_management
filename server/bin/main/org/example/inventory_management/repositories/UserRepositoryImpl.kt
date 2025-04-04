package org.example.inventory_management.repositories

import org.example.inventory_management.dao.UserDao
import org.example.inventory_management.services.UserService

class UserRepositoryImpl(private val userDao: UserDao,
                         private val userService: UserService
) : UserRepository {
    override suspend fun getUser() {
        userService.getUser()
    }

    override suspend fun updateUser() {

    }

    override suspend fun deleteUser() {

    }

    override suspend fun getUserDetails() {
//        userService.getUserDetails()
    }
}