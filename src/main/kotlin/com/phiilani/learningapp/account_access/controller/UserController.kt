package com.phiilani.learningapp.account_access.controller

import org.springframework.web.bind.annotation.*
import com.phiilani.learningapp.account_access.dto.RegisterRequest
import com.phiilani.learningapp.account_access.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun getAll() = service.getUsers()

    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String) = service.getUserByEmail(email)

    @GetMapping("/id/{id}")
    fun getUserById(@PathVariable id: String) = service.getUserById(id)

    @DeleteMapping("/id/{id}")
    fun deleteUserById(@PathVariable id: String) = service.deleteUserById(id)
}