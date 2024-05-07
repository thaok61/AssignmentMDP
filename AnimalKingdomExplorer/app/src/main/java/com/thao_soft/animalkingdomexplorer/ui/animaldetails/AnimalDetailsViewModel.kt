package com.thao_soft.animalkingdomexplorer.ui.animaldetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thao_soft.animalkingdomexplorer.data.model.Animal
import com.thao_soft.animalkingdomexplorer.data.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalDetailsViewModel @Inject constructor(private val animalRepository: AnimalRepository) :
    ViewModel() {
    private val _animals = MutableStateFlow(listOf<Animal>())
    val animals = _animals.asStateFlow()
    private suspend fun getAnimalDetails() {
        animalRepository.getAllAnimals().map {
            _animals.emit(it)
        }.stateIn(viewModelScope).launchIn(viewModelScope)
    }

    init {
        viewModelScope.launch {
            getAnimalDetails()
        }
    }

    fun addAnimalDetails(animal: Animal) {
        viewModelScope.launch {
            animalRepository.insertAnimal(animal)
        }
    }

}