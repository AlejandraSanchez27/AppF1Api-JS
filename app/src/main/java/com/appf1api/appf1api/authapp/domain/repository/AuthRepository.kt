package com.appf1api.appf1api.authapp.domain.repository

import com.appf1api.appf1api.core.util.Resource
import com.appf1api.appf1api.authapp.domain.model.User
import kotlinx.coroutines.flow.Flow

// Contrato que usan los ViewModels. Oculta Retrofit y DataStore de la capa de presentacion.
interface AuthRepository {
    val token: Flow<String?>

    suspend fun register(name: String, email: String, password: String): Resource<String>
    suspend fun login(email: String, password: String): Resource<User>
    suspend fun getProfile(): Resource<User>
    suspend fun logout()
}