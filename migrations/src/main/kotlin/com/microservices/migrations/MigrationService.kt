package com.microservices.migrations

import org.flywaydb.core.Flyway
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class MigrationService {
    @Inject
    lateinit var flyway: Flyway

    fun checkVersion() {
        flyway.clean()
        flyway.migrate()
        println(
            "Migration for: ${flyway.info().current().version}"
        )
    }
}
