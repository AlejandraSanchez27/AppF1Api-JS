package com.appf1api.appf1api.authapp.data.remote.dto

data class AuthResponseDto(
    val message: String?,
    val token: String?,
    val user: UserDto?
)
