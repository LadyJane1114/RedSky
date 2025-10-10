package com.example.redsky

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.redsky.models.Current
import com.example.redsky.models.Forecast
import com.example.redsky.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel : ViewModel(){
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    init {
        val weather = Weather (
            current = Current(
                R.drawable.day_rain,
                "Rainfall",
                13,
                100,
                "Rain",
                "NW",
                20,
                "10th of October, 2025"
            ),
            forecast = listOf(
                Forecast(
                    "Monday",
                    R.drawable.sun_icon,
                    25,
                    20,
                    "Sunny",
                    10,
                    "Rain",
                    10,
                    "NE",
                    15,
                    35
                    ),
                Forecast(
                    "Tuesday",
                    R.drawable.partly_cloudy,
                    17,
                    13,
                    "Partly Cloudy",
                    20,
                    "Rain",
                    20,
                    "NE",
                    25,
                    25
                ),
                Forecast(
                    "Wednesday",
                    R.drawable.rain_cloud,
                    15,
                    12,
                    "Rainfall",
                    10,
                    "Rain",
                    10,
                    "NE",
                    15,
                    35
                ),Forecast(
                    "Thursday",
                    R.drawable.sun_icon,
                    15,
                    13,
                    "Sunny",
                    10,
                    "Rain",
                    5,
                    "NE",
                    20,
                    40
                ),Forecast(
                    "Friday",
                    R.drawable.partly_cloudy,
                    16,
                    10,
                    "Partly Cloudy",
                    20,
                    "Rain",
                    20,
                    "NE",
                    25,
                    25
                )
            )
        ) // close parenthesis for weather class
         _weather.value = weather
    }
}