package com.appf1api.appf1api.authapp.presentation.register

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val successMessage: String? = null,
    val isRegisterSuccessful: Boolean = false
)
