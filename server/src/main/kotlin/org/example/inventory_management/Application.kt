package org.example.inventory_management

import org.example.inventory_management.config.*
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureHTTP()
    configureMonitoring()
    configureTemplating()
    configureDatabases()
    configureFrameworks()
    configureSockets()
    configureAdministration()
    configureRouting()
    configureStatic()
}