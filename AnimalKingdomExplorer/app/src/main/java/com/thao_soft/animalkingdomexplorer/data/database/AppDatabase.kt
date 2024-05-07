package com.thao_soft.animalkingdomexplorer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thao_soft.animalkingdomexplorer.data.dao.AnimalDao
import com.thao_soft.animalkingdomexplorer.data.dao.SpeciesDao
import com.thao_soft.animalkingdomexplorer.data.model.Animal
import com.thao_soft.animalkingdomexplorer.data.model.Species

@Database(entities = [Animal::class, Species::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun animalDao(): AnimalDao
    abstract fun speciesDao(): SpeciesDao
}