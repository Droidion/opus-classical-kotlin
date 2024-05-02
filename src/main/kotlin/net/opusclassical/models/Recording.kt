package net.opusclassical.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Recording(
    val id: Int,
    val coverName: String,
    val length: Int,
    val labelId: Int,
    val workId: Int,
    val yearStart: Int?,
    val yearFinish: Int,
)

object Recordings : Table("recordings") {
    val id: Column<Int> = integer("id")
    val coverName: Column<String> = text("cover_name")
    val length: Column<Int> = integer("length")
    val labelId: Column<Int> = integer("label_id") references Labels.id
    val workId: Column<Int> = integer("work_id") references Works.id
    val yearStart: Column<Int?> = integer("year_end").nullable()
    val yearFinish: Column<Int> = integer("year_finish")
    override val primaryKey = PrimaryKey(id, name = "recordings_pk")
}