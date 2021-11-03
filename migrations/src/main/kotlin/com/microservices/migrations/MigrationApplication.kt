package com.microservices.migrations

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import javax.inject.Inject
import kotlin.system.exitProcess

@QuarkusMain
public class MigrationApplication : QuarkusApplication {
    @Inject
    lateinit var service: MigrationService

    override fun run(vararg args: String?): Int {
        service.checkVersion()
        exitProcess(0)
    }
}
