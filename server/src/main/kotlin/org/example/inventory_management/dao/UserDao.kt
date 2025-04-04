package org.example.inventory_management.dao

import org.example.inventory_management.entity.UserEntity
import org.example.inventory_management.table.user.UserAccountTable
import org.jetbrains.exposed.sql.Op
import org.example.inventory_management.entity.UserDetailEntity


interface UserDao {
    suspend fun findUserByUsername(username: String): UserEntity?
    suspend fun insertUser(user: UserEntity): UserEntity
    suspend fun deleteUser(id: Int): Boolean
    suspend fun getAll(): List<UserEntity>
    suspend fun getAllWithCondition(condition: (UserAccountTable) -> Op<Boolean>): List<UserEntity>
    suspend fun getUserDetailByMain(uuid: String): UserDetailEntity?
}


