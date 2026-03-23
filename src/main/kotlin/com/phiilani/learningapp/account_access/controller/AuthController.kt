package com.phiilani.learningapp.account_access.controller

import com.phiilani.learningapp.account_access.dto.LoginRequest
import com.phiilani.learningapp.account_access.dto.RegisterRequest
import com.phiilani.learningapp.account_access.service.AuthService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val service: AuthService
) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody request: RegisterRequest) =
        service.register(request)

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest) =
        service.login(request)
}