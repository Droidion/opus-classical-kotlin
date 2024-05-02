package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Country(
    val id: Int,
    val name: String
)

object Countries : Table("countries") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    override val primaryKey = PrimaryKey(id, name = "countries_pk")
}