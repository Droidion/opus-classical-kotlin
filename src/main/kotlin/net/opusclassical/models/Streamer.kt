package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@Serializable
data class Streamer(
    val id: Int,
    val name: String,
    val icon: String
)

object Streamers : Table("streamers") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    val iconName: Column<String> = text("icon_name")
    val iconPrefix: Column<String> = text("icon_prefix")
    override val primaryKey = PrimaryKey(id, name = "genres_pk")
}