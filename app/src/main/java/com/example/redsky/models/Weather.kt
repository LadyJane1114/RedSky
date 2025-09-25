package com.example.redsky.models

import android.health.connect.datatypes.units.Temperature
import androidx.annotation.DrawableRes
import com.example.redsky.MainActivity

data class Weather (
    val current: Current,
    val forecast: List<Forecast>
)

data class Current (
    @DrawableRes val weatherImageRes: Int,
    val condition: String,
//    val temperature: MainActivity.Temperature,
    val precipitationAmount: Int,
    val precipitationType: String,
    val windDirection: String,
    val windSpeed: Int
)

data class Forecast (
    val date: String,
    @DrawableRes val weatherImageRes: Int,
//    val temperatureHigh: Temperature,
//    val temperatureLow: Temperature,
    val condition: String,
    val precipitationAmount: Int,
    val precipitationType: String,
    val precipitationProbability: Int,
    val windDirection: String,
    val windSpeed: Int,
    val humidity: Int
)