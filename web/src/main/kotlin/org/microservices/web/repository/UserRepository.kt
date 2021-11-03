package org.microservices.web.repository

import io.quarkus.hibernate.reactive.panache.PanacheRepository
import org.microservices.web.domain.User
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheRepository<User>
