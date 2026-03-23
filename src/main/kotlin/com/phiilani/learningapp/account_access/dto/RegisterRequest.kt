package com.phiilani.learningapp.account_access.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class RegisterRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:Email(message = "Invalid email")
    val email: String,
    @field:NotBlank(message = "Password is required")
    val password: String
)