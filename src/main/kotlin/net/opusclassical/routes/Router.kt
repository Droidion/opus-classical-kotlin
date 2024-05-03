package net.opusclassical.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.div
import kotlinx.html.h1
import net.opusclassical.dao.dao
import net.opusclassical.plugins.respondCss
import net.opusclassical.templates.LayoutTemplate

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
        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.darkBlue
                    margin(0.px)
                }
                rule("h1.page-title") {
                    color = Color.white
                }
            }
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}