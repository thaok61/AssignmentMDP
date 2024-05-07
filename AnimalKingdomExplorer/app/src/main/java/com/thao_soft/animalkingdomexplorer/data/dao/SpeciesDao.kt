package com.thao_soft.animalkingdomexplorer.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.thao_soft.animalkingdomexplorer.data.model.Species
import kotlinx.coroutines.flow.Flow

@Dao
interface SpeciesDao {
    @Query("Select * from species")
    fun getAllSpecies(): Flow<List<Species>>

    @Insert
    suspend fun addSpecies(species: Species)
}