package net.opusclassical.dao

import net.opusclassical.dao.DatabaseSingleton.dbQuery
import net.opusclassical.models.Countries
import net.opusclassical.models.Country
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToArticle(row: ResultRow) = Country(
        id = row[Countries.id],
        name = row[Countries.name]
    )

    override suspend fun allCountries(): List<Country> = dbQuery {
        Countries.selectAll().map(::resultRowToArticle)
    }
}

val dao: DAOFacade = DAOFacadeImpl()