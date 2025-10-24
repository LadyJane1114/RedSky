package com.example.redsky.utilities

import androidx.compose.ui.graphics.Color
import com.example.redsky.ui.theme.DayRain
import com.example.redsky.ui.theme.SunnyBlue

fun getForecastBackgroundColor(condition:String): Color {
    return when (condition.lowercase()){
        "sunny" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.White
    }
}

fun getForecastTextColor(condition:String): Color {
    return when (condition.lowercase()){
        "sunny" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.Black
    }
}

fun getCurrentDayBGColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "clear" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.White
    }
}
fun getCurrentNightBGColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "clear" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.White
    }
}

fun getCurrentDayTextColor(condition: String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "clear" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.Black
    }
}
fun getCurrentNightTextColor(condition: String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "clear" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.White
    }
}

fun getCurrentDayImage(condition:String): Int {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "clear" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.White
    }
}
fun getCurrentNightImage(condition:String): Int {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "clear" -> SunnyBlue
        "cloudy" -> SunnyBlue
        "partly cloudy" -> SunnyBlue
        "overcast" -> SunnyBlue
        "mist" -> SunnyBlue
        "patchy rain nearby" -> SunnyBlue
        "patchy light rain" -> SunnyBlue
        "patchy snow nearby" -> SunnyBlue
        "patchy sleet nearby" -> SunnyBlue
        "patchy freezing drizzle nearby" -> SunnyBlue
        "thundery outbreaks in nearby" -> SunnyBlue
        "blowing snow" -> SunnyBlue
        "blizzard" -> SunnyBlue
        "fog" -> SunnyBlue
        "freezing fog" -> SunnyBlue
        "patchy light drizzle" -> SunnyBlue
        "light drizzle" -> SunnyBlue
        "freezing drizzle" -> SunnyBlue
        "heavy freezing drizzle" -> SunnyBlue
        "light rain" -> SunnyBlue
        "moderate rain at times" -> SunnyBlue
        "moderate rain" -> SunnyBlue
        "heavy rain at times" -> SunnyBlue
        "heavy rain" -> SunnyBlue
        "light freezing rain" -> SunnyBlue
        "moderate or heavy freezing rain" -> SunnyBlue
        "light sleet" -> SunnyBlue
        "moderate or heavy sleet" -> SunnyBlue
        "patchy light snow" -> SunnyBlue
        "light snow" -> SunnyBlue
        "patchy moderate snow" -> SunnyBlue
        "moderate snow" -> SunnyBlue
        "patchy heavy snow" -> SunnyBlue
        "heavy snow" -> SunnyBlue
        "ice pellets" -> SunnyBlue
        "light rain shower" -> SunnyBlue
        "moderate or heavy rain shower" -> SunnyBlue
        "torrential rain shower" -> SunnyBlue
        "light sleet showers" -> SunnyBlue
        "moderate or heavy sleet showers" -> SunnyBlue
        "light snow showers" -> SunnyBlue
        "moderate or heavy snow showers" -> SunnyBlue
        "light showers of ice pellets" -> SunnyBlue
        "moderate or heavy showers of ice pellets" -> SunnyBlue
        "patchy light rain in area with thunder" -> SunnyBlue
        "moderate or heavy rain in area with thunder" -> SunnyBlue
        "patchy light snow in area with thunder" -> SunnyBlue
        "moderate or heavy snow in area with thunder" -> SunnyBlue
        else -> Color.White
    }
}