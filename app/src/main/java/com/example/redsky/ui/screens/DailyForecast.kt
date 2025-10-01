package com.example.redsky.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redsky.models.Forecast
import com.example.redsky.ui.theme.DayRain
import com.example.redsky.ui.theme.NightRain
import com.example.redsky.ui.theme.SunnyBlue
import com.example.redsky.ui.theme.Sunrise



fun getForecastBackgroundColor(condition:String): Color {
    return when (condition.lowercase()){
        "sunny" -> SunnyBlue
        "rainfall" -> DayRain
        "partly cloudy" -> SunnyBlue
        else -> Color.White
    }
}

fun getForecastTextColor(condition:String): Color {
    return when (condition.lowercase()){
        "sunny" -> Color.Black
        "rainfall" -> Color.White
        "partly cloudy" -> Color.Black
        else -> Color.White
    }
}

fun getTodaysBackgroundColor(condition: String): Color {
    return when (condition.lowercase()){
        "sunny" -> SunnyBlue
        "rainfall" -> DayRain
        "partly cloudy" -> SunnyBlue
        else -> Color.White
    }
}


@Composable
fun ForecastList(forecasts: List<Forecast>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(NightRain),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn (
            modifier = Modifier
                .padding(top = 30.dp, bottom = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(modifier = Modifier
                    .padding(bottom = 5.dp),
                    text = "Weekly Forecast",
                    style = MaterialTheme.typography.titleLarge,
                    color = Sunrise
                    )
            }
            items(forecasts){ forecast -> DailyForecast(forecast)}
        }
    }
}

@Composable
fun DailyForecast (forecast: Forecast){
    val forecastBackgroundColor = getForecastBackgroundColor(forecast.condition)
    val forecastTextColor = getForecastTextColor(forecast.condition)
    var isExpanded by remember { mutableStateOf(false) }

//    Box added to help center things properly and make it look nicer
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 5.dp),
        contentAlignment = Alignment.Center
    )
    {
        Row(modifier = Modifier
            .background(forecastBackgroundColor,RoundedCornerShape(15.dp))
            .fillMaxWidth(0.9F)
            .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(15.dp))
            .padding(12.dp)
            .clickable { isExpanded = !isExpanded }

        ){
            Image(
                painterResource(id = forecast.weatherImageRes),
                contentDescription = forecast.condition,
                modifier = Modifier
                    .size(50.dp)
                    .background(color = MaterialTheme.colorScheme.primary, RoundedCornerShape(15.dp))
                    .padding(5.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))


            Column {
                Text(
                    text = forecast.date,
                    style = MaterialTheme.typography.headlineSmall,
                    color = forecastTextColor
                )
                Text(
                    text = "High of: ${forecast.temperatureHigh}°C    Low of: ${forecast.temperatureLow}°C",
                    style = MaterialTheme.typography.titleMedium,
                    color = forecastTextColor
                )
                Text(
                    text = forecast.condition,
                    style = MaterialTheme.typography.titleSmall,
                    color = forecastTextColor
                )
                AnimatedVisibility(visible = isExpanded) {
                    Column {
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
        }
    }

}