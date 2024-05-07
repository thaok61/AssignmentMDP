package com.thao_soft.animalkingdomexplorer.data.repository

import com.thao_soft.animalkingdomexplorer.data.model.Species
import kotlinx.coroutines.flow.Flow

interface SpeciesRepository {
    fun getAllSpecies(): Flow<List<Species>>

    suspend fun insertSpecies(species: Species)
}