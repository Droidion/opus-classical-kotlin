package net.opusclassical.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.opusclassical.dao.dao

fun Application.configureDatabases() {
    routing {

        // Read city
        get("/countries") {
            try {
                val countries = dao.allCountries()
                call.respond(HttpStatusCode.OK, countries)
            } catch (e: Exception) {
                println("CoroutineExceptionHandler got $e")
                call.respond(HttpStatusCode.NotFound)
            }
        }
    
        /*put("/cities/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
            val user = call.receive<City>()
            cityService.update(id, user)
            call.respond(HttpStatusCode.OK)
        }
    
        delete("/cities/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
            cityService.delete(id)
            call.respond(HttpStatusCode.OK)
        }*/
    }
}
