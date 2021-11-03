package org.microservices.web.utils

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.microservices.web.config.QuarkusMappingConfig
import org.microservices.web.domain.User
import org.microservices.web.dto.UserDto

@Mapper(config = QuarkusMappingConfig::class)
interface UserMapper {
    @Mappings(
        Mapping(source = "id", target = "id"),
        Mapping(source = "login", target = "login"),
        Mapping(source = "nodeId", target = "nodeId"),
        Mapping(source = "avatarUrl", target = "avatarUrl"),
        Mapping(source = "siteAdmin", target = "siteAdmin")
    )
    fun toDao(person: UserDto): User

    @InheritInverseConfiguration
    fun toDto(person: User): UserDto;
}
