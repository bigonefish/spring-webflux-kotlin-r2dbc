package com.example.learnspringwebfluxr2dbc

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class R2Controller(
    val userRepository: UserRepository
) {

    @GetMapping("/user/add")
    fun addUsers() : Flux<User> {
        val users = mutableListOf<User>()
        for (i in 1..10000) {
            val user = User(
                name = "이름$i",
                age = 18 + i
            )
            users.add(user)
        }

        return userRepository.saveAll(users)
    }

    @PostMapping("/user")
    fun createUser(user: User) : Mono<User> {
        return userRepository.save(user)
    }

    @GetMapping("/users")
    fun users() : Flux<User> {
        return userRepository.findAll()
    }

    @GetMapping("/user/{id}")
    fun checkUser(@PathVariable id: Long) : Mono<Boolean> {
        return userRepository.existsById(id)
    }

    @Transactional
    @PutMapping("/user/{id}")
    fun updateUser(@PathVariable("id") id: Long) : Mono<User> {
        return userRepository.findById(id).flatMap {
            it.age = it.age + 1
            userRepository.save(it)
        }
//         return userRepository.findById(id).map {
//            it.age = it.age + 1
//            it
//        }
    }

    @Transactional
    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable("id") id: Long) : Mono<Void> {
        return userRepository.findById(id).flatMap {
            userRepository.delete(it)
        }
    }
}