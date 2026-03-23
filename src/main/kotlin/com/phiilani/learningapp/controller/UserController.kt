package com.phiilani.learningapp.controller

import org.springframework.web.bind.annotation.*
import com.phiilani.learningapp.dto.CreateUserRequest
import com.phiilani.learningapp.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@Valid @RequestBody request: CreateUserRequest) =
        service.createUser(request)

    @GetMapping
    fun getAll() = service.getUsers()

    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String) = service.getUserByEmail(email)

    @GetMapping("/id/{id}")
    fun getUserById(@PathVariable id: String) = service.getUserById(id)
}