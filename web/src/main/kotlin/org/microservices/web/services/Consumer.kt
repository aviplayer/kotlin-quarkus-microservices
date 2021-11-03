package org.microservices.web.services

import org.eclipse.microprofile.reactive.messaging.Incoming
import org.microservices.web.dto.UserDto
import org.microservices.web.repository.UserRepository
import org.microservices.web.utils.UserMapper
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class Consumer {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userMapper: UserMapper

    @Incoming("users")
    fun consume(users: Array<UserDto>) {
        users.toList().stream().forEach {
            val usrDao = userMapper.toDao(it)
            val usr = userRepository.persist(usrDao)
                .await().indefinitely()

            println("Saved the user ${usr.login}")
        }
    }
}
