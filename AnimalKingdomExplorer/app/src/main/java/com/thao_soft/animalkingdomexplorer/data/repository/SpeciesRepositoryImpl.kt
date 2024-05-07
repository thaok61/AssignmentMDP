package com.thao_soft.animalkingdomexplorer.data.repository

import com.thao_soft.animalkingdomexplorer.data.dao.SpeciesDao
import com.thao_soft.animalkingdomexplorer.data.model.Species
import kotlinx.coroutines.flow.Flow

class SpeciesRepositoryImpl(private val speciesDao: SpeciesDao): SpeciesRepository {
    override fun getAllSpecies(): Flow<List<Species>> {
        return speciesDao.getAllSpecies()
    }

    override suspend fun insertSpecies(species: Species) {
        return speciesDao.addSpecies(species)
    }
}