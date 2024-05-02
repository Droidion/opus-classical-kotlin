package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Composer(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val yearBorn: Int,
    val yearDied: Int?,
    val periodId: Int,
    val slug: String,
    val wikipediaLink: String?,
    val imslpLink: String?,
    val enabled: Boolean,
)

object Composers : Table("composers") {
    val id: Column<Int> = integer("id")
    val firstName: Column<String> = text("firstName")
    val lastName: Column<String> = text("lastName")
    val yearBorn: Column<Int> = integer("year_born")
    val yearDied: Column<Int?> = integer("year_died").nullable()
    val periodId: Column<Int> = integer("period_id") references Periods.id
    val slug: Column<String> = text("slug")
    val wikipediaLink: Column<String?> = text("wikipedia_link").nullable()
    val imslpLink: Column<String?> = text("imslp_link").nullable()
    override val primaryKey = PrimaryKey(id, name = "composers_pk")
}