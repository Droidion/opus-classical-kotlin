package net.opusclassical.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.div
import kotlinx.html.h1
import net.opusclassical.templates.LayoutTemplate

fun Route.indexRoute() {
    get("/") {
        call.respondHtmlTemplate(LayoutTemplate()) {
            titleText {
                +"Testtt"
            }
            content {
                h1(classes = "page-title") {
                    +"Hello from Ktor!"
                }
                div(classes = "m-12") {
                    +"This should have a huge margin!"
                }
            }
        }
    }
}