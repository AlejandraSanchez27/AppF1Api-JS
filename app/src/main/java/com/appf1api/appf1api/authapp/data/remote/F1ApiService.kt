package com.appf1api.appf1api.authapp.data.remote

import com.appf1api.appf1api.authapp.data.remote.dto.DriverStandingsResponseDto
import com.appf1api.appf1api.authapp.data.remote.dto.NextRaceResponseDto
import retrofit2.http.GET

interface F1ApiService {
    @GET("ergast/f1/current/driverStandings.json")
    suspend fun getDriverStandings(): DriverStandingsResponseDto
    @GET("ergast/f1/current/next.json")
    suspend fun getNextRace(): NextRaceResponseDto
}