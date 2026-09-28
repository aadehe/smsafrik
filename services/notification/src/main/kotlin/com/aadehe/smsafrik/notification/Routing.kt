package com.aadehe.smsafrik.notification

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/health/live") {
            call.respond(
                HttpStatusCode.OK,
                mapOf("status" to "UP")
            )
        }

        get("/health/ready") {
            call.respond(
                HttpStatusCode.OK,
                mapOf("status" to "UP")
            )
        }
    }
}
