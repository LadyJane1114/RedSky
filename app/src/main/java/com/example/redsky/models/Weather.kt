package com.example.redsky.models

import android.health.connect.datatypes.units.Temperature
import androidx.annotation.DrawableRes
import com.example.redsky.MainActivity
import java.time.LocalDate

data class Weather (
    val current: Current,
    val forecast: List<Forecast>
)

data class Current (
    @DrawableRes val weatherImageRes: Int,
    val condition: String,
    val temperature: Int,
    val precipitationAmount: Int,
    val precipitationType: String,
    val windDirection: String,
    val windSpeed: Int,
    val currentDate: String
    // Added current date myself because I thought it would look nice on the page
)

data class Forecast (
    val date: String,
    @DrawableRes val weatherImageRes: Int,
    val temperatureHigh: Int,
    val temperatureLow: Int,
    val condition: String,
    val precipitationAmount: Int,
    val precipitationType: String,
    val precipitationProbability: Int,
    val windDirection: String,
    val windSpeed: Int,
    val humidity: Int
)