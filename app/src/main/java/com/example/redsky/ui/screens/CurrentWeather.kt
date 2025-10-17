package com.example.redsky.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.redsky.MainViewModel
import com.example.redsky.ui.theme.DayRain
import com.example.redsky.ui.theme.SunnyBlue

fun getBackgroundColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "rainfall" -> DayRain
        else -> Color.White
    }
}

fun getTextColor(condition: String): Color {
    return when (condition.lowercase()) {
        "sunny" -> Color.Black
        "rainfall" -> Color.White
        else -> Color.Black
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CurrentWeather(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()

    val condition = weather?.current?.condition!!
    val backgroundColor = getBackgroundColor(condition.text)
    val textColor = getTextColor(condition.text)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = weather?.current?.weatherImageRes!!),
                contentDescription = weather?.current?.condition?.text,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "${weather?.current?.temperature}°C",
                fontSize = 48.sp,
                color = textColor
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Feels like: ${weather?.current?.feelsLike}°C",
                fontSize = 20.sp,
                color = textColor
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = weather!!.current.condition.text,
                fontSize = 30.sp,
                color = textColor
                )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Precipitation: ${weather?.current?.precipitationAmount}mm",
                fontSize = 20.sp,
                color = textColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Wind: ${weather?.current?.windSpeed}mph, ${weather?.current?.windDirection}",
                fontSize = 20.sp,
                color = textColor
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Need to figure out how to make Date Dynamic, but potentially that's in the API? We'll see.
            Text(
                text = "${weather?.current?.currentDate}",
                fontSize = 30.sp,
                color = textColor
            )

        }
    }
}