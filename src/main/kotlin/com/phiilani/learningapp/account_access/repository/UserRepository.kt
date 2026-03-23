package com.phiilani.learningapp.account_access.repository

import com.phiilani.learningapp.account_access.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository  : MongoRepository<User, String>{
    fun findByEmail(email: String): User?
}