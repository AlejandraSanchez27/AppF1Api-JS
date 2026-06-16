package com.appf1api.appf1api.authapp.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.authDataStore by preferencesDataStore(name="auth_preferences")

class TokenManager(private val context: Context) {
    private val tokenKey = stringPreferencesKey("jwt_token")

    val token: Flow<String?> = context.authDataStore.data.map{ preferences ->
        preferences[tokenKey]
    }

    suspend fun saveToken (token: String){
        context.authDataStore.edit { preferences ->
            preferences[tokenKey] = token
        }
    }

    suspend fun cleartoken(){
        context.authDataStore.edit {preferences ->
            preferences.remove(tokenKey)
        }
    }
}