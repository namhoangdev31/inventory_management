package org.example.inventory_management

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform