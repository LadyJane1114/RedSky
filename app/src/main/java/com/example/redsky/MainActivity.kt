package com.example.redsky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.redsky.data.PlaceholderCurrentWeather.sampleCurrent
import com.example.redsky.data.PlaceholderData
import com.example.redsky.data.PlaceholderData.forecastSample
import com.example.redsky.models.Forecast
import com.example.redsky.ui.screens.CurrentWeather
import com.example.redsky.ui.screens.DailyForecast
import com.example.redsky.ui.screens.ForecastList
import com.example.redsky.ui.theme.RedSkyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedSkyTheme {
                MaterialTheme {
//                    CurrentWeather(current = sampleCurrent)
                    ForecastList(forecasts = forecastSample)
               }

            }
        }
    }
}

