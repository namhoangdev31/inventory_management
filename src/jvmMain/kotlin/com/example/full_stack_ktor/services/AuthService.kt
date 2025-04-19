package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.entity.UserEntity
import com.example.full_stack_ktor.model.LoginRequest
import com.example.full_stack_ktor.model.LoginResponse
import com.example.full_stack_ktor.repositories.AuthRepository
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent.inject
import java.util.*

//actual class AuthService: IAuthService {
//    private val authRepository: AuthRepository by inject(AuthRepository::class.java)
//    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
//        return authRepository.login(loginRequest)
//    }
//
//    override suspend fun register(username: String, password: String): String {
//        // Implement your registration logic here
//        return "Registration successful"
//    }
//}
