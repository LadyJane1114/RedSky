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
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.redsky.MainViewModel
import com.example.redsky.R
import com.example.redsky.models.ForecastDay
import com.example.redsky.ui.theme.Pink80
import com.example.redsky.ui.theme.Sunset
import com.example.redsky.utilities.getForecastBGColor
import com.example.redsky.utilities.getForecastTextColor
import com.example.redsky.utilities.convertDate
import kotlin.math.roundToInt

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


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyForecast (forecastDay: ForecastDay){
    val forecast = forecastDay.day
    val forecastBackgroundColor = getForecastBGColor(forecast.condition.text)
    val forecastTextColor = getForecastTextColor(forecast.condition.text)
    var isExpanded by remember { mutableStateOf(false) }

    val iconUrl = if (forecast.condition.icon.startsWith("//")) {
        "https:${forecast.condition.icon}"
    } else forecast.condition.icon

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
                rememberAsyncImagePainter(iconUrl),
                contentDescription = forecast.condition.text,
                modifier = Modifier
                    .size(85.dp)
                    .background(color = Sunset, RoundedCornerShape(20.dp))
                    .padding(5.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(8.dp))


            Column {
                Text(
                    text = convertDate(forecastDay.date),
                    fontSize = 30.sp,
                    color = forecastTextColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = forecast.condition.text,
                    fontSize = 26.sp,
                    color = forecastTextColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "High: ${forecast.temperatureHigh.roundToInt()}°C   Low: ${forecast.temperatureLow.roundToInt()}°C",
                    fontSize = 20.sp,
                    color = forecastTextColor
                )
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Spacer(modifier = Modifier.height(4.dp))
                        forecast.precipitationAmount.takeIf {it >= 1}?.let{
                            Text(
                                text = "Precipitation: ${forecast.precipitationAmount.roundToInt()}mm",
                                fontSize = 18.sp,
                                color = forecastTextColor
                            )
                        }
                        forecast.snowAmount.takeIf {it >= 1}?.let{
                            Text(
                                text = "Snow: ${forecast.snowAmount.roundToInt()}cm",
                                fontSize = 18.sp,
                                color = forecastTextColor
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Wind: ${forecast.windSpeed.roundToInt()}mph, ${forecast.windDirection}",
                            fontSize = 18.sp,
                            color = forecastTextColor
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}