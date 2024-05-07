package com.thao_soft.animalkingdomexplorer.di

import android.content.Context
import androidx.room.Room
import com.thao_soft.animalkingdomexplorer.data.dao.AnimalDao
import com.thao_soft.animalkingdomexplorer.data.dao.SpeciesDao
import com.thao_soft.animalkingdomexplorer.data.database.AppDatabase
import com.thao_soft.animalkingdomexplorer.data.repository.AnimalRepository
import com.thao_soft.animalkingdomexplorer.data.repository.AnimalRepositoryImpl
import com.thao_soft.animalkingdomexplorer.data.repository.SpeciesRepository
import com.thao_soft.animalkingdomexplorer.data.repository.SpeciesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "animal-kingdom-explorer")
            .build()
    }

    @Singleton
    @Provides
    fun provideAnimalDao(db: AppDatabase): AnimalDao {
        return db.animalDao()
    }

    @Singleton
    @Provides
    fun provideSpeciesDao(db: AppDatabase): SpeciesDao {
        return db.speciesDao()
    }

    @Singleton
    @Provides
    fun provideAnimalRepository(animalDao: AnimalDao): AnimalRepository {
        return AnimalRepositoryImpl(animalDao)
    }

    @Singleton
    @Provides
    fun provideSpeciesRepository(speciesDao: SpeciesDao): SpeciesRepository {
        return SpeciesRepositoryImpl(speciesDao)
    }
}