package net.opusclassical

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import net.opusclassical.dao.DatabaseSingleton
import net.opusclassical.plugins.*
import io.github.cdimascio.dotenv.dotenv

fun main(args: Array<String>): Unit = EngineMain.main(args)

//embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
//        .start(wait = true)

fun Application.module() {
    DatabaseSingleton.init(dotenv()["DB_URL"])
    configureSerialization()
    configureDatabases()
    configureTemplating()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}
