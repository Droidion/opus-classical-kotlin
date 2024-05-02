package net.opusclassical.models

import org.jetbrains.exposed.sql.*

object ComposersCountriesRelations : Table("composers_countries") {
    val composerId: Column<Int> = integer("composer_id") references Composers.id
    val countryId: Column<Int> = integer("country_id") references Countries.id
    override val primaryKey = PrimaryKey(composerId, countryId, name = "composers_countries_pk")
}