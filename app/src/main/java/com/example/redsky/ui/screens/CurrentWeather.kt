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
import com.example.redsky.utilities.getCurrentDayImage
import com.example.redsky.utilities.getCurrentNightImage
import com.example.redsky.utilities.getDayBGColor
import com.example.redsky.utilities.getDayTextColor
import com.example.redsky.utilities.getNightBGColor
import com.example.redsky.utilities.convertDate
import kotlin.math.roundToInt


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CurrentWeather(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()

    if (weather == null){
        Text("Loading weather data...",
            fontSize = 20.sp,
            color = Color.Gray)
        return
    }

    val condition = weather?.current?.condition!!
    val isDay = weather?.current?.isDay == 1

    val weatherImage: Int
    val backgroundColor: Color
    val textColor: Color

    if(isDay){
        weatherImage = getCurrentDayImage(condition.text)
        backgroundColor = getDayBGColor(condition.text)
        textColor = getDayTextColor(condition.text)
    } else {
        weatherImage = getCurrentNightImage(condition.text)
        backgroundColor = getNightBGColor(condition.text)
        textColor = Color.White
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = weatherImage),
                contentDescription = weather?.current?.condition?.text,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "${weather?.current?.temperature!!.roundToInt()}°C",
                fontSize = 48.sp,
                color = textColor
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Feels like: ${weather?.current?.feelsLike!!.roundToInt()}°C",
                fontSize = 20.sp,
                color = textColor
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = weather!!.current.condition.text,
                fontSize = 30.sp,
                color = textColor
                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Wind: ${weather?.current?.windSpeed!!.roundToInt()}mph, ${weather?.current?.windDirection}",
                fontSize = 20.sp,
                color = textColor
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Need to figure out how to make Date Dynamic, but potentially that's in the API? We'll see.
            Text(
                text = convertDate(weather?.current!!.currentDate),
                fontSize = 30.sp,
                color = textColor
            )

        }
    }
}