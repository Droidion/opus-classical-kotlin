package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@Serializable
data class Genre(
    val id: Int,
    val name: String,
    val icon: String
)

object Genres : Table("genres") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    val icon: Column<String> = text("icon")
    override val primaryKey = PrimaryKey(id, name = "genres_pk")
}