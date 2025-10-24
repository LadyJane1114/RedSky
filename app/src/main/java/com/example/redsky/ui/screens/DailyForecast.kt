package com.example.redsky.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.redsky.MainViewModel
import com.example.redsky.R
import com.example.redsky.models.Forecast
import com.example.redsky.models.ForecastDay
import com.example.redsky.ui.theme.DayRain
import com.example.redsky.ui.theme.SunnyBlue
import com.example.redsky.ui.theme.Sunset
import com.example.redsky.utilities.getDayBGColor
import com.example.redsky.utilities.getDayTextColor


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastList(mainViewModel: MainViewModel) {

    val weather by mainViewModel.weather.collectAsState()
    val forecasts = weather?.forecast?.forecastDay

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.forecast_red_ocean),
            contentDescription = "Red Ocean",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        if (forecasts != null){
            LazyColumn {
                items(forecasts) { forecastDay ->
                    DailyForecast(forecastDay)
                }
            }
        }
    }
}


@Composable
fun DailyForecast (forecastDay: ForecastDay){
    val forecast = forecastDay.day
    val forecastBackgroundColor = getDayBGColor(forecast.condition.text)
    val forecastTextColor = getDayTextColor(forecast.condition.text)
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
            .border(2.dp, Sunset, RoundedCornerShape(15.dp))
            .padding(12.dp)
            .clickable { isExpanded = !isExpanded }

        ){
            Image(
                rememberAsyncImagePainter(forecastDay?.day?.condition?.icon),
                contentDescription = forecast.condition.text,
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
                    text = forecastDay?.day.toString(),
                    fontSize = 26.sp,
                    color = forecastTextColor
                )
                Text(
                    text = "High of: ${forecast.temperatureHigh}°C    Low of: ${forecast.temperatureLow}°C",
                    fontSize = 18.sp,
                    color = forecastTextColor
                )
                Text(
                    text = forecast.condition.text,
                    fontSize = 16.sp,
                    color = forecastTextColor
                )
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Text(
                            text = "Precipitation: ${forecast.precipitationAmount}mm",
                            fontSize = 16.sp,
                            color = forecastTextColor
                        )
                        Text(
                            text = "Wind: ${forecast.windSpeed}mph, ${forecast.windDirection}",
                            fontSize = 16.sp,
                            color = forecastTextColor
                        )
                    }

                    }
            }
        }
    }

}