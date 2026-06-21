package com.appf1api.appf1api.authapp.presentation.race

import androidx.lifecycle.ViewModel
import com.appf1api.appf1api.authapp.domain.model.Race
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RaceViewModel : ViewModel() {
    private val _selectedRace =
        MutableStateFlow<Race?>(null)
    val selectedRace: StateFlow<Race?> =
        _selectedRace.asStateFlow()
    fun selectRace(race: Race) {
        _selectedRace.value = race
    }
}