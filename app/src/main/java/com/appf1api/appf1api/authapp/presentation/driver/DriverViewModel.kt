package com.appf1api.appf1api.authapp.presentation.driver

import androidx.lifecycle.ViewModel
import com.appf1api.appf1api.authapp.domain.model.Driver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DriverViewModel : ViewModel() {
    private val _selectedDriver =
        MutableStateFlow<Driver?>(null)
    val selectedDriver: StateFlow<Driver?> =
        _selectedDriver.asStateFlow()
    fun selectDriver(driver: Driver) {
        _selectedDriver.value = driver
    }
}