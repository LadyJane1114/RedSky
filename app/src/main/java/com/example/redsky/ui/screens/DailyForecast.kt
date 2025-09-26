package com.example.redsky.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redsky.models.Forecast
import com.example.redsky.ui.theme.DayRain
import com.example.redsky.ui.theme.SunnyBlue


fun getForecastBackgroundColor(condition:String): Color {
    return when (condition.lowercase()){
        "sunny" -> SunnyBlue
        "rainy" -> DayRain
        "partly cloudy" -> SunnyBlue
        else -> Color.White
    }
}

fun getForecastTextColor(condition:String): Color {
    return when (condition.lowercase()){
        "sunny" -> Color.Black
        "rainy" -> Color.White
        "partly cloudy" -> Color.Black
        else -> Color.White
    }
}

@Composable
fun ForecastList(forecasts: List<Forecast>) {
    LazyColumn {
        items(forecasts){ forecast -> DailyForecast(forecast)}
    }
}


@Composable
fun DailyForecast (forecast: Forecast){
    val forecastBackgroundColor = getBackgroundColor(forecast.condition)
    val forecastTextColor = getForecastTextColor(forecast.condition)

    Row(modifier = Modifier
        .padding(17.dp)
        .background(forecastBackgroundColor)
    ){
        Image(
            painterResource(id = forecast.weatherImageRes),
            contentDescription = forecast.condition,
            modifier = Modifier
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = forecast.condition,
                style = MaterialTheme.typography.bodyMedium,
                color = forecastTextColor
            )
            Text(
                text = "Precipitation: ${forecast.precipitationAmount}mm, ${forecast.precipitationType}",
                style = MaterialTheme.typography.bodyMedium,
                color = forecastTextColor
            )
            Text(
                text = "Wind: ${forecast.windSpeed}mph, ${forecast.windDirection}",
                style = MaterialTheme.typography.bodyMedium,
                color = forecastTextColor
            )
        }

    }
}