package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Period(
    val id: Int,
    val name: String,
    val yearStart: Int,
    val yearEnd: Int?,
    val slug: String
)

object Periods : Table("periods") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    val yearStart: Column<Int> = integer("year_start")
    val yearEnd: Column<Int?> = integer("year_end").nullable()
    val slug: Column<String> = text("slug")
    override val primaryKey = PrimaryKey(id, name = "periods_pk")
}