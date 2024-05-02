package net.opusclassical.models

import kotlinx.serialization.Serializable
import net.opusclassical.models.ComposersCountriesRelations.references
import net.opusclassical.models.Periods.references
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@Serializable
data class Work(
    val id: Int,
    val title: String,
    val composerId: Int,
    val yearStart: Int?,
    val yearFinish: Int?,
    val averageMinutes: Int?,
    val isGroup: Boolean,
    val parentGroupId: Int?,
    val catalogueId: Int?,
    val catalogueNumber: Int?,
    val cataloguePostfix: String?,
    val no: Int?,
    val nickname: String?,
    val sort: Int?,
    val genreId: Int?,

)

object Works : Table("works") {
    val id: Column<Int> = integer("id")
    val title: Column<String> = text("title")
    val composerId: Column<Int> = integer("composer_id") references Composers.id
    val yearStart: Column<Int?> = integer("year_start").nullable()
    val yearFinish: Column<Int?> = integer("year_finish").nullable()
    val averageMinutes: Column<Int?> = integer("average_minutes").nullable()
    val isGroup: Column<Boolean> = bool("is_group")
    val parentWorkId: Column<Int?> = integer("parent_work_id").nullable()
    val catalogueId: Column<Int?> = (integer("parent_work_id") references Catalogues.id).nullable()
    val catalogueNumber: Column<Int?> = integer("catalogue_number").nullable()
    val cataloguePostfix: Column<String?> = text("catalogue_postfix").nullable()
    val no: Column<Int?> = integer("no").nullable()
    val nickname: Column<String?> = text("nickname").nullable()
    val sort: Column<Int?> = integer("sort").nullable()
    val genreId: Column<Int?> = (integer("genre_id") references Genres.id).nullable()
    override val primaryKey = PrimaryKey(id, name = "genres_pk")
}
