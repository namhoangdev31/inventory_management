package com.example.full_stack_ktor.repositories

import com.example.full_stack_ktor.dao.UserDao
import com.example.full_stack_ktor.services.UserService

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