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
    @SerializedName("last_updated")
    val currentDate: String,
    @SerializedName("is_day")
    val isDay: Int// Figure out a way to format this nicely, because the way it's formatted in the API is gross

)
data class Forecast(
    @SerializedName("forecastday")
    val forecastDay: List<ForecastDay>
)

data class ForecastDay (
    val date: String,
    val day: Day
//    val astro: Astro // including this for later if I have time to use it
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
    val snowAmount: Float, // for later
    @SerializedName("daily_chance_of_rain")
    val precipitationProbability: Float,
    @SerializedName("daily_chance_of_snow")
    val showProbability:Float, // for later
    @SerializedName("wind_dir")
    val windDirection: String,
    @SerializedName("maxwind_kph")
    val windSpeed: Float,
    val avghumidity: Float
)

data class Condition (
    val text: String,
    val icon: String
)

//data class Astro (
//    @SerializedName("moon_phase")
//    val moonPhase: String
//) for later