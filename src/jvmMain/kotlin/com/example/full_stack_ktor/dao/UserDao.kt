package com.example.full_stack_ktor.dao

import com.example.full_stack_ktor.entity.UserEntity
import com.example.full_stack_ktor.table.user.UserAccountTable
import org.jetbrains.exposed.sql.Op
import com.example.full_stack_ktor.entity.UserDetailEntity


interface UserDao {
    suspend fun findUserByUsername(username: String): UserEntity?
    suspend fun insertUser(user: UserEntity): UserEntity
    suspend fun deleteUser(id: Int): Boolean
    suspend fun getAll(): List<UserEntity>
    suspend fun getAllWithCondition(condition: (UserAccountTable) -> Op<Boolean>): List<UserEntity>
    suspend fun getUserDetailByMain(uuid: String): UserDetailEntity?
}


