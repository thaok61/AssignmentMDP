package com.thao_soft.animalkingdomexplorer.data.repository

import com.thao_soft.animalkingdomexplorer.data.dao.AnimalDao
import com.thao_soft.animalkingdomexplorer.data.model.Animal
import kotlinx.coroutines.flow.Flow

class AnimalRepositoryImpl(private val animalDao: AnimalDao): AnimalRepository {
    override fun getAllAnimals(): Flow<List<Animal>> {
        return animalDao.getAllAnimals()
    }

    override suspend fun insertAnimal(animal: Animal) {
        return animalDao.addAnimal(animal)
    }
}