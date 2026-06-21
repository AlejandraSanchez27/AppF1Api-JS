package com.appf1api.appf1api.authapp.presentation.home

import com.appf1api.appf1api.authapp.domain.model.User
import com.appf1api.appf1api.authapp.domain.model.Driver
import com.appf1api.appf1api.authapp.domain.model.Race

data class HomeUiState(
    val isLoading: Boolean = true,
    val user: User? = null,
    val errorMessage: String? = null,
    val isLoggedOut: Boolean = false,
    val drivers: List<Driver> = emptyList(),
    val nextRace: Race? = null
)
