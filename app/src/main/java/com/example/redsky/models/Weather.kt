package com.example.redsky.models

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName


data class Weather (
    val current: Current,
    val forecast: List<Forecast>
)

data class Current (
    @DrawableRes val weatherImageRes: Int, //Going to have to get rid of this and do it a different way (same way as the other background/font stuff)
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
    val currentDate: String // Figure out a way to format this nicely, because the way it's formatted in the API is gross

)

data class Forecast (
    val date: String, // same note as above
    @DrawableRes val weatherImageRes: Int, // Same as above probably?
    @SerializedName("maxtemp_c")
    val temperatureHigh: Float,
    @SerializedName("mintemp_c")
    val temperatureLow: Float,
    val condition: Condition,
    @SerializedName("totalprecip_mm")
    val precipitationAmount: Float,
//    @SerializedName("totalsnow_cm")
//    val snowAmount: Float, // for later
    @SerializedName("daily_chance_of_rain")
    val precipitationProbability: Float,
//    @SerializedName("daily_chance_of_snow")
//    val showProbability:Float, // for later
    @SerializedName("wind_dir")
    val windDirection: String,
    @SerializedName("maxwind_kph")
    val windSpeed: Float,
    val avghumidity: Float
)

data class Condition (
    val text: String
)