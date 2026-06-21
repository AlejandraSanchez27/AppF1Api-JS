package com.appf1api.appf1api.authapp.data.remote.dto

data class DriverStandingsResponseDto(
    val MRData: MRDataDto
)

data class MRDataDto(
    val StandingsTable: StandingsTableDto
)

data class StandingsTableDto(
    val StandingsLists: List<StandingsListDto>
)

data class StandingsListDto(
    val DriverStandings: List<DriverStandingDto>
)

data class DriverStandingDto(
    val position: String,
    val points: String,
    val wins: String,
    val Driver: DriverInfoDto,
    val Constructors: List<ConstructorDto>
)

data class DriverInfoDto(
    val driverId: String,
    val givenName: String,
    val familyName: String,
    val nationality: String
)

data class ConstructorDto(
    val name: String
)
