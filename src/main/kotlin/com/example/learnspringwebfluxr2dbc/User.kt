package com.example.learnspringwebfluxr2dbc

import org.springframework.data.annotation.Id

data class User(
    @Id
    val id: Long = 0,
    var name: String,
    var age: Int
)
