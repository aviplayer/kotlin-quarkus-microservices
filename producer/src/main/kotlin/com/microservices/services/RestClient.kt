package com.microservices.services

import com.microservices.models.User
import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.groups.UniAwait
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.mutiny.core.Vertx
import io.vertx.mutiny.ext.web.client.WebClient
import java.util.*
import java.util.logging.Logger
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

const val URL = "api.github.com"

@ApplicationScoped
class RestClient @Inject constructor(vertx: Vertx?) {
    private var client: WebClient = WebClient.create(
        vertx,
        WebClientOptions().setDefaultHost(URL).setDefaultPort(443).setSsl(true)
            .setTrustAll(true)
    )

    fun getAllUsers(fn: (Array<User>) -> (Unit)): UniAwait<Array<User>>? {
        return client
            .get("/users")
            .putHeader("User-Agent", "Quarkus App")
            .addQueryParam("since", "0")
            .addQueryParam("per_page", "10")
            .method(HttpMethod.GET)
            .send()
            .onItem()
            .transform { res ->
                res.bodyAsJson(Array<User>::class.java)
            }
            .invoke(fn)
            .await();
    }

}

