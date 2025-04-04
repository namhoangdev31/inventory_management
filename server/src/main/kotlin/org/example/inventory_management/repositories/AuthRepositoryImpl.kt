package org.example.inventory_management.repositories

import org.example.inventory_management.exceptions.AuthenticationException
import org.example.inventory_management.models.AuthRequest
import org.example.inventory_management.models.AuthResponse
import org.example.inventory_management.models.RegisterRequest
import org.example.inventory_management.models.RegisterResponse
import org.example.inventory_management.services.AuthService
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.inventory_management.dao.UserDao
import org.example.inventory_management.entity.UserEntity
import org.mindrot.jbcrypt.BCrypt
import java.util.UUID.randomUUID

class AuthRepositoryImpl(
    private val userDao: UserDao,
    private val authService: AuthService
) : AuthRepository {

    override suspend fun login(postParam: AuthRequest): AuthResponse {
        val user = userDao.findUserByUsername(postParam.username)
            ?: throw AuthenticationException("Invalid username or password")

        if (!BCrypt.checkpw(postParam.password, user.passwordHash)) {
            throw AuthenticationException("Invalid password")
        }

        val token = authService.generateToken(user)

        return AuthResponse(
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
}
