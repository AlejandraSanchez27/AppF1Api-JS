package com.appf1api.appf1api.authapp.domain.model

import com.appf1api.appf1api.authapp.data.remote.dto.DriverStandingDto

data class Driver(
    val id: String,
    val position: String,
    val points: String,
    val wins: String,
    val fullName: String,
    val nationality: String,
    val team: String
)

fun DriverStandingDto.toDomain(): Driver {
    return Driver(
        id = Driver.driverId,
        position = position,
        points = points,
        wins = wins,
        fullName = "${Driver.givenName} ${Driver.familyName}",
        nationality = Driver.nationality,
        team = Constructors.firstOrNull()?.name ?: "Sin equipo"
    )
}
