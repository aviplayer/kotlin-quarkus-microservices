package org.microservices.web.api

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.microservices.web.dto.UserDto
import org.microservices.web.repository.UserRepository
import org.microservices.web.utils.UserMapper
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("users")
class UserController {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userMapper: UserMapper

    @GET
    fun getUsers(): Multi<UserDto> {

        return userRepository.streamAll()
            .map { usr -> userMapper.toDto(usr) }

    }

    @GET
    @Path("{id}")
    fun getUserById(id: Long): Uni<UserDto> {

        return userRepository.findById(id)
            .map { usr -> userMapper.toDto(usr) }

    }
}
