package net.opusclassical.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.opusclassical.dao.dao

fun Application.configureRouter() {
    routing {
        indexRoute()
        get("/countries") {
            try {
                val countries = dao.allCountries()
                call.respond(HttpStatusCode.OK, countries)
            } catch (e: Exception) {
                println("CoroutineExceptionHandler got $e")
                call.respond(HttpStatusCode.NotFound)
            }
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}