package com.thao_soft.animalkingdomexplorer.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.thao_soft.animalkingdomexplorer.data.model.Animal
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDao {
    @Query("Select * from animal")
    fun getAllAnimals(): Flow<List<Animal>>

    @Insert
    suspend fun addAnimal(animal: Animal)
}