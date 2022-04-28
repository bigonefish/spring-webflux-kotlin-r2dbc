package com.example.learnspringwebfluxr2dbc

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserRepository : ReactiveCrudRepository<User, Long>