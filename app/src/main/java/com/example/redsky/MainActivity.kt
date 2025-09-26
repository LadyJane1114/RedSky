package com.example.redsky

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.redsky.models.Current
import com.example.redsky.ui.screens.CurrentWeather
import com.example.redsky.ui.theme.RedSkyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//need to add some sort of way for the app to tell what time of day it is if I want to include my nighttime backgrounds. Also need to include some snow backgrounds because I forgot!! oopsie
        val sampleCurrent = Current(
//            weatherImageRes = R.drawable.afternoon_sunny,
//            condition = "Sunny",
////            temperature = Temperature(current = 25),
//            precipitationAmount = 0,
//            precipitationType = "None",
//            windDirection = "NE",
//            windSpeed = 15
            weatherImageRes = R.drawable.day_rain,
            condition = "Rainy",
//            temperature = Temperature(current = 25),
            precipitationAmount = 100,
            precipitationType = "Rain",
            windDirection = "NW",
            windSpeed = 20
        )

        setContent {
            RedSkyTheme {
                MaterialTheme {
                    CurrentWeather(current = sampleCurrent)
                }

            }
        }
    }
}

