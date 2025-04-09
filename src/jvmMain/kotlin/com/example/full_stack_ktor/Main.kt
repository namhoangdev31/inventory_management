package com.example.full_stack_ktor

import com.example.full_stack_ktor.config.*
import io.ktor.server.application.*

fun Application.main() {
    configureSecurity()
    configureSerialization()
    configureHTTP()
    configureMonitoring()
    configureDatabases()
    configureFrameworks()
    configureSockets()
    configureAdministration()
    configureRouting()
    configureStatic()
}
