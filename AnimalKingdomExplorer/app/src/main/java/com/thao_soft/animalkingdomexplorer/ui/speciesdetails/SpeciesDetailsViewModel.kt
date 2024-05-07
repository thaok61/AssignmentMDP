package com.thao_soft.animalkingdomexplorer.ui.speciesdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thao_soft.animalkingdomexplorer.data.model.Species
import com.thao_soft.animalkingdomexplorer.data.repository.SpeciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeciesDetailsViewModel @Inject constructor(private val speciesRepository: SpeciesRepository) :
    ViewModel() {
    private val _species = MutableStateFlow(listOf<Species>())
    val species = _species.asStateFlow()
    private suspend fun getSpeciesDetails() {
        speciesRepository.getAllSpecies().map {
            _species.emit(it)
        }.stateIn(viewModelScope).launchIn(viewModelScope)
    }

    init {
        viewModelScope.launch {
            getSpeciesDetails()
        }
    }

    fun addSpecies(species: Species) {
        viewModelScope.launch {
            speciesRepository.insertSpecies(species)
        }
    }
}