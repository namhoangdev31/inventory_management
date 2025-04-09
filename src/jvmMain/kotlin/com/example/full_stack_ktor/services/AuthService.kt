package com.example.full_stack_ktor.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.full_stack_ktor.IAuthService
import com.example.full_stack_ktor.entity.UserEntity
import io.ktor.server.application.*
import org.koin.java.KoinJavaComponent.inject
import java.util.*

actual class AuthService: IAuthService {
    private val environment: ApplicationEnvironment by inject(ApplicationEnvironment::class.java)
    private val jwtSecret: String = environment.config.property("jwt.secret").getString()
    private val jwtIssuer: String = environment.config.property("jwt.issuer").getString()
    private val jwtAudience: String = environment.config.property("jwt.audience").getString()

    fun generateToken(user: UserEntity): String {
        return JWT.create()
            .withAudience(jwtAudience)
            .withIssuer(jwtIssuer)
            .withClaim("username", user.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 3600000)) // Token expires in 1 hour
            .sign(Algorithm.HMAC256(jwtSecret))
    }

    fun validateToken(token: String): Boolean {
        return try {
            val verifier = JWT.require(Algorithm.HMAC256(jwtSecret))
                .withAudience(jwtAudience)
                .withIssuer(jwtIssuer)
                .build()
            verifier.verify(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun extractUsername(token: String): String? {
        return try {
            val jwt = JWT.decode(token)
            jwt.getClaim("username").asString()
        } catch (e: Exception) {
            null
        }
    }

    fun extractIsAdmin(token: String): Boolean {
        return try {
            val jwt = JWT.decode(token)
            jwt.getClaim("isAdmin").asBoolean()
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun login(username: String, password: String): String {
        // Implement your login logic here
        return "Login successful"
    }

    override suspend fun register(username: String, password: String): String {
        // Implement your registration logic here
        return "Registration successful"
    }
}
