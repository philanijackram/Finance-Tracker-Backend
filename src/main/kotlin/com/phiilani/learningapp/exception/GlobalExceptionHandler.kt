package com.phiilani.learningapp.exception


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(ex: Exception): Map<String, String> {
        return mapOf("error" to (ex.message ?: "Unknown error"))
    }
}