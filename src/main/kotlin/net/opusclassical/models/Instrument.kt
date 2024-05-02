package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Instrument(
    val id: Int,
    val name: String
)

object Instruments : Table("instruments") {
    val id: Column<Int> = integer("id")
    val name: Column<String> = text("name")
    override val primaryKey = PrimaryKey(id, name = "instruments_pk")
}