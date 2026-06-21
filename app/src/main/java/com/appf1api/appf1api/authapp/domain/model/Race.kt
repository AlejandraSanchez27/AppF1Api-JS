package com.appf1api.appf1api.authapp.domain.model

data class Race(
    val raceName: String,
    val circuitName: String,
    val country: String,
    val locality: String,
    val date: String,
    val time: String?
)
