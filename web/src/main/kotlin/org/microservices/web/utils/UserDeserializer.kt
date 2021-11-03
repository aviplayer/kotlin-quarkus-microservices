package org.microservices.web.utils

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer
import org.microservices.web.dto.UserDto

class UserDeserializer() :
    ObjectMapperDeserializer<Array<UserDto>>(Array<UserDto>::class.java) {}
