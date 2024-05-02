package net.opusclassical.models

import kotlinx.serialization.Serializable
import net.opusclassical.models.ComposersCountriesRelations.references
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table


@Serializable
data class Link(
    val recordingId: Int,
    val streamerId: Int,
    val link: String,
    val isShow: Boolean,
)

object Links : Table("links") {
    val recordingId: Column<Int> = integer("recording_id") references Recordings.id
    val streamerId: Column<Int> = integer("streamer_id") references Streamers.id
    val link: Column<String> = text("link")
    val isShow: Column<Boolean> = bool("is_show")
    override val primaryKey = PrimaryKey(recordingId, streamerId, name = "links_pk")
}