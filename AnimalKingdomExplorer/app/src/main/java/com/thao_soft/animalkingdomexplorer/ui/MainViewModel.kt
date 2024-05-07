package com.thao_soft.animalkingdomexplorer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _title = MutableStateFlow("Home")
    val title = _title.asStateFlow()

    private val _isShowBackButton = MutableStateFlow(false)
    private val _currentTypeFabButton = MutableStateFlow(-1)
    val isShowBackButton = _isShowBackButton.asStateFlow()
    val currentTypeFabButton = _currentTypeFabButton.asStateFlow()
    fun setTitle(newTitle: String) {
        viewModelScope.launch {
            _title.emit(newTitle)
        }
    }

    fun setShowBackButton(showBackButton: Boolean) {
        viewModelScope.launch {
            _isShowBackButton.emit(showBackButton)
        }
    }

    fun setCurrentTypeFabButton(type: Int) {
        viewModelScope.launch {
            _currentTypeFabButton.emit(type)
        }
    }

}