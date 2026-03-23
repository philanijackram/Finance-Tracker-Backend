package com.phiilani.learningapp.account_access.service

import com.phiilani.learningapp.account_access.dto.UserResponse
import com.phiilani.learningapp.account_access.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repo: UserRepository) {

    fun getUsers(): List<UserResponse> {
        val users = repo.findAll()

        val response = users.map {
            UserResponse(
                id = it.id,
                name = it.name,
                email = it.email,
            )
        }

        return response

    }

    fun getUserByEmail(email: String): UserResponse? {
        val user = repo.findByEmail(email)
        return if (user == null)
            null else
            UserResponse(
                user.id,
                user.name,
                user.email,
            )
    }

    fun getUserById(id: String): UserResponse? {
        val user = repo.findById(id).orElse(null)
        return if (user == null)
            null else
            UserResponse(
                user.id,
                user.name,
                user.email,
            )
    }

    fun deleteUserById(id: String) {

        repo.deleteById(id)

    }
}