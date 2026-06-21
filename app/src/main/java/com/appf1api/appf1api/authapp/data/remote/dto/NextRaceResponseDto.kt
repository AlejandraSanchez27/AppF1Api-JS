package com.appf1api.appf1api.authapp.data.remote.dto

import com.appf1api.appf1api.authapp.domain.model.Race

data class NextRaceResponseDto(
    val MRData: RaceMRDataDto
)

data class RaceMRDataDto(
    val RaceTable: RaceTableDto
)

data class RaceTableDto(
    val Races: List<RaceDto>
)

data class RaceDto(
    val raceName: String,
    val round: String,
    val date: String,
    val time: String?,
    val Circuit: CircuitDto
)

data class CircuitDto(
    val circuitName: String,
    val Location: LocationDto
)

data class LocationDto(
    val locality: String,
    val country: String
)
fun RaceDto.toDomain(): Race {
    return Race(
        raceName = raceName,
        circuitName = Circuit.circuitName,
        country = Circuit.Location.country,
        locality = Circuit.Location.locality,
        date = date,
        time = time
    )
}