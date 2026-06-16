package com.appf1api.appf1api.authapp.presentation.auth

interface AuthLoadingUiState {
    data object Loading : AuthLoadingUiState
    data object Authenticated : AuthLoadingUiState
    data object Unauthenticated : AuthLoadingUiState
}