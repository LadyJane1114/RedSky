package com.example.redsky

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.redsky.models.Condition
import com.example.redsky.models.Current
import com.example.redsky.models.Forecast
import com.example.redsky.models.Weather
import com.example.redsky.services.WeatherService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel : ViewModel(){
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

//    val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("http://api.weatherapi.com/v1/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    init {
        val weather = Weather (
            current = Current(
                R.drawable.day_rain,
                Condition(
                    text = "Rainfall"
                ),
                13f,
                15f,
                100f,
                "NW",
                20f,
                "10th of October, 2025"
            ),
            forecast = listOf(
                Forecast(
                    "Monday",
                    R.drawable.sun_icon,
                    25f,
                    20f,
                    Condition(
                        text = "Sunny"
                    ),
                    10f,
                    10f,
                    "NE",
                    15f,
                    35f
                    ),
                Forecast(
                    "Tuesday",
                    R.drawable.partly_cloudy,
                    17f,
                    13f,
                    Condition(
                        text = "Partly Cloudy"
                    ),
                    20f,
                    20f,
                    "NE",
                    25f,
                    25f
                ),
                Forecast(
                    "Wednesday",
                    R.drawable.rain_cloud,
                    15f,
                    12f,
                    Condition(
                        text = "Rainfall"
                    ),
                    10f,
                    10f,
                    "NE",
                    15f,
                    35f
                ),Forecast(
                    "Thursday",
                    R.drawable.sun_icon,
                    15f,
                    13f,
                    Condition(
                        text = "Sunny"
                    ),
                    10f,
                    5f,
                    "NE",
                    20f,
                    40f
                ),Forecast(
                    "Friday",
                    R.drawable.partly_cloudy,
                    16f,
                    10f,
                    Condition(
                        text = "Partly Cloudy"
                    ),
                    20f,
                    20f,
                    "NE",
                    25f,
                    25f
                )
            )
        ) // close parenthesis for weather class
         _weather.value = weather
    }
}