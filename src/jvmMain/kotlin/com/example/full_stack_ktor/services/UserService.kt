package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.User

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class UserService: IUserService {
    fun getUser() {

    }

    override suspend fun login(email: String?, password: String?): User {
        TODO("Not yet implemented")
    }

    override suspend fun register(username: String?, email: String?, password: String?): User {
        TODO("Not yet implemented")
    }

    override suspend fun user(): User {
        TODO("Not yet implemented")
    }

    override suspend fun settings(
        image: String?,
        username: String?,
        bio: String?,
        email: String?,
        password: String?
    ): User {
        TODO("Not yet implemented")
    }

    override suspend fun profile(username: String): User {
        TODO("Not yet implemented")
    }

    override suspend fun profileFollow(username: String, follow: Boolean): User {
        TODO("Not yet implemented")
    }
}
