package net.opusclassical.dao

import net.opusclassical.models.Country

interface DAOFacade {
    suspend fun allCountries(): List<Country>
}