package com.example.redsky.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redsky.models.Forecast


@Composable
fun DailyForecast (forecast: Forecast){
    Row(modifier = Modifier.padding(17.dp)){
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
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Precipitation: ${forecast.precipitationAmount}mm, ${forecast.precipitationType}",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Wind: ${forecast.windSpeed}mph, ${forecast.windDirection}",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}