package org.microservices.web.domain

import javax.persistence.*

@Entity
@Cacheable
@Table(name = "users")
data class User(
    @Id
    var id: Long? = null,

    @Column(name = "login")
    var login: String? = null,

    @Column(name = "node_id")
    var nodeId: String? = null,

    @Column(name = "avatar_url")
    var avatarUrl: String? = null,

    @Column(name = "site_admin")
    var siteAdmin: Boolean? = null
)
