package com.phiilani.learningapp.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:Email(message = "Invalid email")
    val email: String
)