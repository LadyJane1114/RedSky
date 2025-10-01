package com.example.redsky.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redsky.models.Current
import com.example.redsky.ui.theme.DayRain
import com.example.redsky.ui.theme.SunnyBlue

fun getBackgroundColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "rainy" -> DayRain
        else -> Color.White
    }
}

fun getTextColor(condition: String): Color {
    return when (condition.lowercase()) {
        "sunny" -> Color.Black
        "rainy" -> Color.White
        else -> Color.Black
    }
}
@Composable
fun CurrentWeather(current: Current) {
    val backgroundColor = getBackgroundColor(current.condition)
    val textColor = getTextColor(current.condition)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = current.weatherImageRes),
                contentDescription = current.condition,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp)
            )

            Text(
                text = "${current.temperature}°C",
                style = MaterialTheme.typography.headlineLarge,
                color = textColor
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = current.condition,
                style = MaterialTheme.typography.headlineMedium,
                color = textColor
                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Precipitation: ${current.precipitationAmount}mm, ${current.precipitationType}",
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Wind: ${current.windSpeed}mph, ${current.windDirection}",
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
            )

        }
    }
}