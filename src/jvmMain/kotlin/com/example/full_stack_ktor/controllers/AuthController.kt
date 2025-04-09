package com.example.full_stack_ktor.controllers

import com.example.full_stack_ktor.models.AuthRequest
import com.example.full_stack_ktor.models.RegisterRequest
import com.example.full_stack_ktor.exceptions.AuthenticationException
import com.example.full_stack_ktor.repositories.AuthRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.koin.java.KoinJavaComponent.inject

class AuthController {
    private val authRepository: AuthRepository by inject(AuthRepository::class.java)
    suspend fun login(call: ApplicationCall) {
        val postParam = call.receive<AuthRequest>()
        try {
            val response = authRepository.login(postParam)
            call.respond(response)
        } catch (e: AuthenticationException) {
            throw AuthenticationException(e.message ?: "Authentication failed")
        }
    }

    suspend fun register(call: ApplicationCall) {
        try {
            val postParam = call.receive<RegisterRequest>()
            val response = authRepository.register(postParam)
            call.respond(response)
        } catch (e: AuthenticationException) {
            throw AuthenticationException(e.message ?: "Authentication failed")
        }
    }
}



