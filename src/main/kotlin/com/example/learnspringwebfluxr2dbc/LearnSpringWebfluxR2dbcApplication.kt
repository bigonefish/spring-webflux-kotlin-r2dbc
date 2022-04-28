package com.example.learnspringwebfluxr2dbc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories
@EnableR2dbcAuditing
class LearnSpringWebfluxR2dbcApplication

fun main(args: Array<String>) {
    runApplication<LearnSpringWebfluxR2dbcApplication>(*args)
}
