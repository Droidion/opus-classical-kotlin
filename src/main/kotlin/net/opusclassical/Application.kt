package net.opusclassical

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.opusclassical.dao.DatabaseSingleton
import net.opusclassical.plugins.*
import io.github.cdimascio.dotenv.dotenv
import net.opusclassical.routes.configureRouter

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    DatabaseSingleton.init(dotenv()["DB_URL"])
    configureRouter()

    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}
