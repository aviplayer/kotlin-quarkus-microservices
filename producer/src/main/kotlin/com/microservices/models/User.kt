package com.microservices.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    @field:JsonProperty("login")
    val    login: String? = null,
    @field:JsonProperty("id")
    val    id: Int? = null,
    @field:JsonProperty("node_id")
    val    node_id: String? = null,
    @field:JsonProperty("avatar_url")
    val    avatar_url: String? = null,
    @field:JsonProperty("site_admin")
    val    site_admin: Boolean? = null
)
