package com.microservices.config

import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EmitterConfig(@Channel("users") userEmitter: Emitter<String>) {
    val emitter = userEmitter

    fun sendMsg(msg: String){
        emitter.send(msg)
    }
}
