package com.appf1api.appf1api.authapp.presentation.home

import com.appf1api.appf1api.authapp.domain.model.User

data class HomeUiState(
    val isLoading: Boolean = true,
    val user: User? = null,
    val errorMessage: String? = null,
    val isLoggedOut: Boolean = false
)
