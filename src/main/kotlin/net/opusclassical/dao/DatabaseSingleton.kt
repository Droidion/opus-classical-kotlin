package net.opusclassical.dao

import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

object DatabaseSingleton {
    fun init(jdbcURL: String) {
        val driverClassName = "org.postgresql.Driver"
        Database.connect(jdbcURL, driverClassName)
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}

