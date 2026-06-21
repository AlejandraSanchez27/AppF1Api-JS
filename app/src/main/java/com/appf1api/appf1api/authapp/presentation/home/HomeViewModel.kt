package com.appf1api.appf1api.authapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.appf1api.appf1api.authapp.data.remote.dto.toDomain
import com.appf1api.appf1api.authapp.domain.model.Driver
import com.appf1api.appf1api.authapp.domain.model.toDomain
import com.appf1api.appf1api.core.util.Resource
import com.appf1api.appf1api.authapp.domain.repository.AuthRepository
import com.appf1api.appf1api.core.network.F1RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Carga el perfil autenticado y coordina el cierre de sesion.
class HomeViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
        loadDrivers()
        loadNextRace()
    }
    fun loadProfile() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            when (val result = repository.getProfile()) {
                is Resource.Success -> _uiState.update {
                    it.copy(isLoading = false, user = result.data)
                }
                is Resource.Error -> _uiState.update {
                    it.copy(isLoading = false, errorMessage = result.message)
                }
                Resource.Loading -> _uiState.update { it.copy(isLoading = true) }
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            _uiState.update { it.copy(isLoggedOut = true) }
        }
    }

    fun resetLogoutState() {
        _uiState.update { it.copy(isLoggedOut = false) }
    }

    class Factory(private val repository: AuthRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(repository) as T
        }
    }

    private fun loadDrivers() {
        viewModelScope.launch {
            try {
                val response = F1RetrofitClient.api.getDriverStandings()
                val drivers = response.MRData
                    .StandingsTable
                    .StandingsLists[0]
                    .DriverStandings
                    .map { it.toDomain() }

                _uiState.update {
                    it.copy(drivers = drivers)
                }
                Log.d(
                    "F1_API",
                    "Pilotos cargados: ${drivers.size}"
                )
            } catch (e: Exception) {
                Log.e(
                    "F1_API",
                    "ERROR -> ${e.message}",
                    e
                )
            }
        }
    }
    private fun loadNextRace() {
        viewModelScope.launch {
            try {
                val response =
                    F1RetrofitClient.api.getNextRace()
                val race =
                    response.MRData
                        .RaceTable
                        .Races[0]
                        .toDomain()
                _uiState.update {
                    it.copy(nextRace = race)
                }
                Log.d("F1_RACE", race.raceName)
            } catch (e: Exception) {
                Log.e(
                    "F1_RACE",
                    e.message ?: "error"
                )
            }
        }
    }
}