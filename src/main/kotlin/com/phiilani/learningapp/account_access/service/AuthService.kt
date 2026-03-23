package com.phiilani.learningapp.account_access.service

import com.phiilani.learningapp.account_access.dto.LoginRequest
import com.phiilani.learningapp.account_access.dto.RegisterRequest
import com.phiilani.learningapp.account_access.dto.UserResponse
import com.phiilani.learningapp.account_access.model.User
import com.phiilani.learningapp.account_access.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthService(
    private val repo: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun register(request: RegisterRequest): UserResponse {

        if (repo.findByEmail(request.email) != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists")
        }

        val user = User(
            name = request.name,
            email = request.email,
            password = passwordEncoder.encode(request.password) // 🔐 hash
        )

        val newUser = repo.save(user)

        return UserResponse(
            id = newUser.id,
            name = newUser.name,
            email = newUser.email,
        )
    }

    fun login(request: LoginRequest): UserResponse {

        val user = repo.findByEmail(request.email)
            ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials")

        val matches = passwordEncoder.matches(request.password, user.password)

        if (!matches) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials")
        }

        return UserResponse(
            user.id,
            user.name,
            user.email,
        )
    }
}