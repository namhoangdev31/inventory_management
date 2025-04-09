package com.example.full_stack_ktor.models

import kotlinx.serialization.Serializable

@Serializable
class RegisterResponse (
    var statusMessage: String = "User registered successfully",
    var username: String = "",
    var email: String = "",
    var id: Int = 0,
    var token: String = ""
)