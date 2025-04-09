package com.example.full_stack_ktor.exceptions

class AuthenticationException(message: String = "Authentication Failed") : RuntimeException(message)
