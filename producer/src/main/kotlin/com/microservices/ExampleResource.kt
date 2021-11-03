package com.microservices

import com.fasterxml.jackson.databind.ObjectMapper
import com.microservices.config.EmitterConfig
import com.microservices.services.RestClient
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import java.time.Duration
import java.util.logging.Logger
import javax.enterprise.inject.Default
import javax.inject.Inject

@QuarkusMain
class Producer : QuarkusApplication {
    private val LOGGER: Logger = Logger.getLogger(Producer::class.java.getName())

    @Inject
    var client: RestClient? = null

    @Inject
    lateinit var objectMapper: ObjectMapper

    @Inject
    @field: Default
    lateinit var emitterCfg: EmitterConfig

    @Throws(Exception::class)
    override fun run(vararg args: String): Int {
        LOGGER.info("Thread is: ${Thread.currentThread().name}")
        client?.getAllUsers { users ->
            emitterCfg.sendMsg(
                objectMapper.writeValueAsString(users)
            )
            users.forEach { usr ->
                usr.also { LOGGER.info("User: $it") }
                    .run { LOGGER.warning("With $login") }
            }
        }
            ?.atMost(Duration.ofSeconds(10));
        return 0
    }
}
