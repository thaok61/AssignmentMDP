package com.thao_soft.animalkingdomexplorer.data.repository

import com.thao_soft.animalkingdomexplorer.data.model.Animal
import kotlinx.coroutines.flow.Flow


interface AnimalRepository {
    fun getAllAnimals(): Flow<List<Animal>>

    suspend fun insertAnimal(animal: Animal)
}