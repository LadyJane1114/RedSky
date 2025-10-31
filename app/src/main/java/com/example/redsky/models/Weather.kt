package com.example.redsky.models

import android.location.Location
import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName


data class Weather (
    @SerializedName("location")
    val myLocation: MyLocation,
    val current: Current,
    val forecast: Forecast
)
data class MyLocation(
    val name: String,
    val region: String,
    val country: String,
    val lat: Float,
    val lon: Float,
    val localtime: String
)

data class Current (
    val condition: Condition,
    @SerializedName ("temp_c")
    val temperature: Float,
    @SerializedName("feelslike_c")
    val feelsLike: Float,
    @SerializedName ("precip_mm")
    val precipitationAmount: Float,
    @SerializedName("wind_dir")
    val windDirection: String,
    @SerializedName("wind_kph")
    val windSpeed: Float,
    @SerializedName("last_updated_epoch")
    val currentDate: Long,
    @SerializedName("is_day")
    val isDay: Int

)
data class Forecast(
    @SerializedName("forecastday")
    val forecastDay: List<ForecastDay>
)

data class ForecastDay (
    @SerializedName("date_epoch")
    val date: Long,
    val day: Day,
    val astro: Astro
)

data class Day (
    @SerializedName("maxtemp_c")
    val temperatureHigh: Float,
    @SerializedName("mintemp_c")
    val temperatureLow: Float,
    val condition: Condition,
    @SerializedName("totalprecip_mm")
    val precipitationAmount: Float,
    @SerializedName("totalsnow_cm")
    val snowAmount: Float,
    @SerializedName("wind_dir")
    val windDirection: String,
    @SerializedName("maxwind_kph")
    val windSpeed: Float
)

data class Condition (
    val text: String,
    val icon: String
)

data class Astro (
    @SerializedName("moon_phase")
    val moonPhase: String
)