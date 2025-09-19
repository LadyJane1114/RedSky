package com.example.redsky.models

import android.health.connect.datatypes.units.Temperature

data class Weather (
    val current: Current,
    val forecast: List<Forecast>
)

data class Current (
    val weatherImage: String,
    val condition: String,
    val temperature: Temperature,
    val precipitationAmount: Int,
    val precipitationType: String,
    val windDirection: String,
    val windSpeed: Int
)

data class Forecast (
    val date: String,
    val weatherImage: String,
    val temperatureHigh: Temperature,
    val temperatureLow: Temperature,
    val condition: String,
    val precipitationAmount: Int,
    val precipitationType: String,
    val precipitationProbability: Int,
    val windDirection: String,
    val windSpeed: Int,
    val humidity: Int
)