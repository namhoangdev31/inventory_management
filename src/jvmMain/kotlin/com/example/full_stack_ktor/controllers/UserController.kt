package com.example.full_stack_ktor.controllers

import com.example.full_stack_ktor.repositories.UserRepository
import com.example.full_stack_ktor.utils.AppRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject


class UserController {
    private val userRepository: UserRepository by inject(UserRepository::class.java)

    suspend fun getUser(call: ApplicationCall) {
        val user = userRepository.getUser()
        call.respond(user)
    }
}

