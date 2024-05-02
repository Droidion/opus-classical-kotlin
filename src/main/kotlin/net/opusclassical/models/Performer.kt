package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Performer(
    val id: Int,
    val firstName: String?,
    val lastName: String,
)

object Performers : Table("performers") {
    val id: Column<Int> = integer("id")
    val firstName: Column<String?> = text("name").nullable()
    val lastName: Column<String> = text("last_name")
    override val primaryKey = PrimaryKey(id, name = "performers_pk")
}