package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Label(
    val id: Int,
    val name: String
)

object Labels : Table("labels") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    override val primaryKey = PrimaryKey(id, name = "labels_pk")
}