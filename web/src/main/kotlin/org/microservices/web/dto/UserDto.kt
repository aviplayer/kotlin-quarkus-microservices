package org.microservices.web.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto(
    @field:JsonProperty("login")
    var    login: String? = null,
    @field:JsonProperty("id")
    var    id: Int? = null,
    @field:JsonProperty("node_id")
    var    nodeId: String? = null,
    @field:JsonProperty("avatar_url")
    var    avatarUrl: String? = null,
    @field:JsonProperty("site_admin")
    var    siteAdmin: Boolean? = null
)
