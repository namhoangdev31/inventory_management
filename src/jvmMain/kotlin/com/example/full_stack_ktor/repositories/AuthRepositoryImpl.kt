package com.example.full_stack_ktor.repositories

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.full_stack_ktor.entity.UserEntity
import com.example.full_stack_ktor.exceptions.AuthenticationException
import com.example.full_stack_ktor.dao.UserDao
import com.example.full_stack_ktor.model.LoginRequest
import com.example.full_stack_ktor.model.LoginResponse
import com.example.full_stack_ktor.models.AuthRequest
import com.example.full_stack_ktor.models.*
//import com.example.full_stack_ktor.services.AuthService
import io.ktor.server.application.ApplicationEnvironment
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.koin.java.KoinJavaComponent.inject
import org.mindrot.jbcrypt.BCrypt
import java.util.Date
import java.util.UUID.randomUUID
import kotlin.getValue

class AuthRepositoryImpl(
    private val userDao: UserDao,
) : AuthRepository {
    private val environment: ApplicationEnvironment by inject(ApplicationEnvironment::class.java)
    private val jwtSecret: String = environment.config.property("jwt.secret").getString()
    private val jwtIssuer: String = environment.config.property("jwt.issuer").getString()
    private val jwtAudience: String = environment.config.property("jwt.audience").getString()
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        val user = userDao.findUserByUsername(loginRequest.username)
            ?: throw AuthenticationException("Invalid username or password")

        if (!BCrypt.checkpw(loginRequest.password, user.passwordHash)) {
            throw AuthenticationException("Invalid password")
        }

        val token = this.generateToken(user)

        return LoginResponse(
            statusMessage = "Login Successful",
            error = null,
            tokenAccess = token
        ).copy(error = null).also {
            println("Generated Token: $token")  // For debug purposes
        }
    }

    override suspend fun register(postParam: RegisterRequest): RegisterResponse {
        if (userDao.findUserByUsername(postParam.username) != null) {
            throw AuthenticationException("Username already exists")
        }

        val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

        val hashedPassword = BCrypt.hashpw(postParam.password, BCrypt.gensalt())

        val newUser = UserEntity(
            uuid = randomUUID().toString(),
            username = postParam.username,
            passwordHash = hashedPassword,
            email = postParam.email ?: "",
            isActive = postParam.isActive,
            createdAt = currentTime,
        )

        userDao.insertUser(newUser)

        return RegisterResponse(
            statusMessage = "User registered successfully",

        )
    }

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
}
