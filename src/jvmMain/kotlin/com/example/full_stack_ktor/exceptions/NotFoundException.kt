package com.example.full_stack_ktor.exceptions

class NotFoundException(message: String = "Resource not found") : RuntimeException(message)
