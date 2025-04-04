package org.example.fullstack_management

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform