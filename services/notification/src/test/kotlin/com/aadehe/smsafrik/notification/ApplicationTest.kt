package com.aadehe.smsafrik.notification

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `liveness endpoint returns healthy status`() = testApplication {
        application {
            module()
        }

        val response = client.get("/health/live")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("""{"status":"UP"}""", response.bodyAsText())
    }
}
