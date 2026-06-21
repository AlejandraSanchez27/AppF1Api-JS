package com.appf1api.appf1api.authapp.data.remote

import com.appf1api.appf1api.authapp.data.remote.dto.AuthResponseDto
import com.appf1api.appf1api.authapp.data.remote.dto.LoginRequestDto
import com.appf1api.appf1api.authapp.data.remote.dto.RegisterRequestDto
import com.appf1api.appf1api.authapp.data.remote.dto.RegisterResponseDto
import com.appf1api.appf1api.authapp.data.remote.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthApiService {
    //Endpoint de registro: POST

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequestDto): Response<RegisterResponseDto>
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequestDto): Response<AuthResponseDto>
    @GET("users/me")
    suspend fun getProfile(): Response<UserDto>
}