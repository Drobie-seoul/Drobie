package com.drobie.client.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    data class SplashUiState(
        val isFinished: Boolean = false
    )

    private val _uiState = MutableStateFlow(SplashUiState())
    var uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000L)
            _uiState.update { it.copy(isFinished = true) }
        }
    }

}