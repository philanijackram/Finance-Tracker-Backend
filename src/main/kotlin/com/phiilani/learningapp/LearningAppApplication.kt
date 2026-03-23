package com.phiilani.learningapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.phiilani.learningapp.account_access.repository"])
class LearningAppApplication

fun main(args: Array<String>) {
    runApplication<LearningAppApplication>(*args)
}
