package com.phiilani.learningapp.service

import com.phiilani.learningapp.dto.CreateUserRequest
import com.phiilani.learningapp.model.User
import com.phiilani.learningapp.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(private val repo: UserRepository) {

    fun createUser(request: CreateUserRequest): User {

        if (repo.findByEmail(request.email) != null) {
            // Throw 400 Bad Request if email already exists
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists")
        }

        val user = User(
            name = request.name,
            email = request.email
        )
        return repo.save(user)
    }

    fun getUsers(): List<User> = repo.findAll()

    fun getUserByEmail(email: String): User? = repo.findByEmail(email)

    fun getUserById(id: String): User? = repo.findById(id).orElse(null)
}