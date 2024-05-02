package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Catalogue(
    val id: Int,
    val name: String,
    val composerId: Int,
)

object Catalogues : Table("catalogues") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    val composerId: Column<Int> = integer("composerId") references Composers.id
    override val primaryKey = PrimaryKey(id, name = "catalogues_pk")
}