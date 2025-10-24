package com.example.redsky.utilities

import androidx.annotation.DrawableRes
import com.example.redsky.R
import androidx.compose.ui.graphics.Color
import com.example.redsky.ui.theme.Blizzard
import com.example.redsky.ui.theme.CloudyDay
import com.example.redsky.ui.theme.CloudyNight
import com.example.redsky.ui.theme.Midnight
import com.example.redsky.ui.theme.SunnyBlue
import com.example.redsky.ui.theme.FogDay
import com.example.redsky.ui.theme.FrFogDay
import com.example.redsky.ui.theme.LRainDay
import com.example.redsky.ui.theme.LRainNight
import com.example.redsky.ui.theme.LRainNoSunDay
import com.example.redsky.ui.theme.LRainNoSunNight
import com.example.redsky.ui.theme.PartCloudDay
import com.example.redsky.ui.theme.PartCloudNight
import com.example.redsky.ui.theme.ThunderDay
import com.example.redsky.ui.theme.ThunderNight
import com.example.redsky.ui.theme.ThunderSnowDay
import com.example.redsky.ui.theme.ThunderSnowNight
import com.example.redsky.ui.theme.TorrentialDay
import com.example.redsky.ui.theme.TorrentialNight


fun getDayBGColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "cloudy" -> CloudyDay
        "partly cloudy" -> PartCloudDay
        "overcast" -> CloudyDay
        "mist" -> PartCloudDay
        "patchy rain nearby" -> LRainDay
        "patchy light rain" -> LRainDay
        "patchy snow nearby" -> 
        "patchy sleet nearby" ->
        "patchy freezing drizzle nearby" ->
        "thundery outbreaks in nearby" ->
        "blowing snow" -> Blizzard
        "blizzard" -> Blizzard
        "fog" -> FogDay
        "freezing fog" -> FrFogDay
        "patchy light drizzle" -> LRainNoSunDay
        "light drizzle" -> LRainNoSunDay
        "freezing drizzle" -> LRainNoSunDay
        "heavy freezing drizzle" -> CloudyDay
        "light rain" -> LRainNoSunDay
        "moderate rain at times" -> LRainDay
        "moderate rain" -> LRainNoSunDay
        "heavy rain at times" -> PartCloudDay
        "heavy rain" -> CloudyDay
        "light freezing rain" ->
        "moderate or heavy freezing rain" -> LRainNoSunDay
        "light sleet" -> LRainNoSunDay
        "moderate or heavy sleet" -> LRainNoSunDay
        "patchy light snow" ->
        "light snow" -> LRainNoSunDay
        "patchy moderate snow" -> LRainNoSunDay
        "moderate snow" -> LRainNoSunDay
        "patchy heavy snow" ->
        "heavy snow" -> CloudyDay
        "ice pellets" -> LRainNoSunDay
        "light rain shower" -> LRainDay
        "moderate or heavy rain shower" -> PartCloudDay
        "torrential rain shower" -> TorrentialDay
        "light sleet showers" ->
        "moderate or heavy sleet showers" -> LRainNoSunDay
        "light snow showers" ->
        "moderate or heavy snow showers" ->
        "light showers of ice pellets" ->
        "moderate or heavy showers of ice pellets" -> LRainNoSunDay
        "patchy light rain in area with thunder" -> ThunderDay
        "moderate or heavy rain in area with thunder" -> ThunderDay
        "patchy light snow in area with thunder" -> ThunderSnowDay
        "moderate or heavy snow in area with thunder" -> ThunderSnowDay
        else -> Color.White
    }
}
fun getNightBGColor(condition:String): Color {
    return when (condition.lowercase()) {
        "clear" -> Midnight
        "cloudy" -> CloudyNight
        "partly cloudy" -> PartCloudNight
        "overcast" ->
        "mist" -> PartCloudNight
        "patchy rain nearby" -> LRainNight
        "patchy light rain" -> LRainNight
        "patchy snow nearby" ->
        "patchy sleet nearby" ->
        "patchy freezing drizzle nearby" ->
        "thundery outbreaks in nearby" ->
        "blowing snow" -> Blizzard
        "blizzard" -> Blizzard
        "fog" -> CloudyNight
        "freezing fog" -> CloudyNight
        "patchy light drizzle" ->
        "light drizzle" ->
        "freezing drizzle" -> LRainNoSunNight
        "heavy freezing drizzle" -> CloudyNight
        "light rain" -> LRainNoSunNight
        "moderate rain at times" -> LRainNight
        "moderate rain" -> LRainNoSunNight
        "heavy rain at times" -> LRainNight
        "heavy rain" -> CloudyNight
        "light freezing rain" ->
        "moderate or heavy freezing rain" -> LRainNoSunNight
        "light sleet" -> LRainNoSunNight
        "moderate or heavy sleet" -> LRainNoSunNight
        "patchy light snow" ->
        "light snow" -> LRainNoSunNight
        "patchy moderate snow" -> LRainNoSunNight
        "moderate snow" -> LRainNoSunNight
        "patchy heavy snow" ->
        "heavy snow" -> CloudyNight
        "ice pellets" -> LRainNoSunNight
        "light rain shower" -> LRainNight
        "moderate or heavy rain shower" -> LRainNight
        "torrential rain shower" -> TorrentialNight
        "light sleet showers" ->Color.Black
        "moderate or heavy sleet showers" -> LRainNoSunNight
        "light snow showers" ->
        "moderate or heavy snow showers" ->
        "light showers of ice pellets" ->
        "moderate or heavy showers of ice pellets" -> LRainNoSunNight
        "patchy light rain in area with thunder" -> ThunderNight
        "moderate or heavy rain in area with thunder" ->  ThunderNight
        "patchy light snow in area with thunder" -> ThunderSnowNight
        "moderate or heavy snow in area with thunder" -> ThunderSnowNight
        else -> Color.Black
    }
}

fun getDayTextColor(condition: String): Color {
    return when (condition.lowercase()) {
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
fun getNightTextColor(condition: String): Color {
    return when (condition.lowercase()) {
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
@DrawableRes
fun getCurrentDayImage(condition:String): Int {
    return when (condition.lowercase()) {
        "sunny" -> R.drawable.current_sunny
        "cloudy" -> R.drawable.current_cloudy_day
        "partly cloudy" -> R.drawable.current_part_cloudy_day
        "overcast" -> R.drawable.current_cloudy_day
        "mist" -> R.drawable.current_mist_day
        "patchy rain nearby" -> R.drawable.current_l_rain_sun_day
        "patchy light rain" -> R.drawable.current_l_rain_sun_day
        "patchy snow nearby" -> R.drawable.current_l_snow_sun_day
        "patchy sleet nearby" -> R.drawable.current_l_sleet_sun_day
        "patchy freezing drizzle nearby" -> R.drawable.current_l_fr_rain_sun_day
        "thundery outbreaks in nearby" -> R.drawable.current_thunder_sun_day
        "blowing snow" -> R.drawable.current_blizzard_day
        "blizzard" -> R.drawable.current_blizzard_day
        "fog" -> R.drawable.current_fog_day
        "freezing fog" -> R.drawable.current_fr_fog_day
        "patchy light drizzle" -> R.drawable.current_mod_rain_no_sun_day
        "light drizzle" -> R.drawable.current_mod_rain_no_sun_day
        "freezing drizzle" -> R.drawable.current_mod_fr_rain_no_sun_day
        "heavy freezing drizzle" -> R.drawable.current_h_fr_rain_no_sun_day
        "light rain" -> R.drawable.current_l_rain_no_sun_day
        "moderate rain at times" -> R.drawable.current_l_rain_sun_day
        "moderate rain" -> R.drawable.current_l_rain_no_sun_day
        "heavy rain at times" -> R.drawable.current_h_rain_sun_day
        "heavy rain" -> R.drawable.current_h_rain_no_sun_day
        "light freezing rain" -> R.drawable.current_l_fr_rain_sun_day
        "moderate or heavy freezing rain" -> R.drawable.current_mod_fr_rain_no_sun_day
        "light sleet" -> R.drawable.current_l_sleet_no_sun_day
        "moderate or heavy sleet" -> R.drawable.current_l_sleet_no_sun_day
        "patchy light snow" -> R.drawable.current_l_snow_sun_day
        "light snow" -> R.drawable.current_l_snow_no_sun_day
        "patchy moderate snow" -> R.drawable.current_l_snow_no_sun_day
        "moderate snow" -> R.drawable.current_mod_snow_no_sun_day
        "patchy heavy snow" -> R.drawable.current_h_snow_sun_day
        "heavy snow" -> R.drawable.current_h_snow_no_sun_day
        "ice pellets" -> R.drawable.current_l_pellets_no_sun_day
        "light rain shower" -> R.drawable.current_l_rain_sun_day
        "moderate or heavy rain shower" -> R.drawable.current_h_rain_sun_day
        "torrential rain shower" -> R.drawable.current_torrential_day
        "light sleet showers" -> R.drawable.current_l_sleet_sun_day
        "moderate or heavy sleet showers" -> R.drawable.current_mod_sleet_sun_day
        "light snow showers" -> R.drawable.current_l_snow_sun_day
        "moderate or heavy snow showers" -> R.drawable.current_h_snow_sun_day
        "light showers of ice pellets" -> R.drawable.current_l_pellets_sun_day
        "moderate or heavy showers of ice pellets" -> R.drawable.current_h_pellets_sun_day
        "patchy light rain in area with thunder" -> R.drawable.current_thunder_sun_day
        "moderate or heavy rain in area with thunder" -> R.drawable.current_thunder_no_sun_day
        "patchy light snow in area with thunder" -> R.drawable.current_thunder_snow_sun_day
        "moderate or heavy snow in area with thunder" -> R.drawable.current_thunder_snow_no_sun_day
        else -> R.drawable.current_default_day
    }
}
@DrawableRes
fun getCurrentNightImage(condition:String): Int {
    return when (condition.lowercase()) {
        "clear" -> R.drawable.current_clear
        "cloudy" -> R.drawable.current_cloudy_night
        "partly cloudy" -> R.drawable.current_part_cloudy_night
        "overcast" -> R.drawable.current_cloudy_night
        "mist" -> R.drawable.current_mist_night
        "patchy rain nearby" -> R.drawable.current_l_rain_clear_night
        "patchy light rain" -> R.drawable.current_l_rain_clear_night
        "patchy snow nearby" -> R.drawable.current_l_snow_clear_night
        "patchy sleet nearby" -> R.drawable.current_l_sleet_clear_night
        "patchy freezing drizzle nearby" -> R.drawable.current_l_fr_rain_clear_night
        "thundery outbreaks in nearby" -> R.drawable.current_thunder_clear_night
        "blowing snow" -> R.drawable.current_blizzard_night
        "blizzard" -> R.drawable.current_blizzard_night
        "fog" -> R.drawable.current_fog_night
        "freezing fog" -> R.drawable.current_fr_fog_night
        "patchy light drizzle" -> R.drawable.current_mod_rain_no_sun_night
        "light drizzle" -> R.drawable.current_mod_rain_no_sun_night
        "freezing drizzle" -> R.drawable.current_mod_fr_rain_no_sun_night
        "heavy freezing drizzle" -> R.drawable.current_h_fr_rain_no_sun_night
        "light rain" -> R.drawable.current_l_rain_no_sun_night
        "moderate rain at times" -> R.drawable.current_l_rain_clear_night
        "moderate rain" -> R.drawable.current_l_rain_no_sun_night
        "heavy rain at times" -> R.drawable.current_h_rain_clear_night
        "heavy rain" -> R.drawable.current_h_rain_no_sun_night
        "light freezing rain" -> R.drawable.current_l_fr_rain_clear_night
        "moderate or heavy freezing rain" -> R.drawable.current_mod_fr_rain_no_sun_night
        "light sleet" -> R.drawable.current_l_sleet_no_sun_night
        "moderate or heavy sleet" -> R.drawable.current_l_sleet_no_sun_night
        "patchy light snow" -> R.drawable.current_l_snow_clear_night
        "light snow" -> R.drawable.current_l_snow_no_sun_night
        "patchy moderate snow" -> R.drawable.current_l_snow_no_sun_night
        "moderate snow" -> R.drawable.current_mod_snow_no_sun_night
        "patchy heavy snow" -> R.drawable.current_h_snow_clear_night
        "heavy snow" -> R.drawable.current_h_snow_no_sun_night
        "ice pellets" -> R.drawable.current_l_pellets_no_sun_night
        "light rain shower" -> R.drawable.current_l_rain_clear_night
        "moderate or heavy rain shower" -> R.drawable.current_h_rain_clear_night
        "torrential rain shower" -> R.drawable.current_torrential_night
        "light sleet showers" -> R.drawable.current_l_sleet_clear_night
        "moderate or heavy sleet showers" -> R.drawable.current_mod_sleet_clear_night
        "light snow showers" -> R.drawable.current_l_snow_clear_night
        "moderate or heavy snow showers" -> R.drawable.current_h_snow_clear_night
        "light showers of ice pellets" -> R.drawable.current_l_pellets_clear_night
        "moderate or heavy showers of ice pellets" -> R.drawable.current_h_pellets_clear_night
        "patchy light rain in area with thunder" -> R.drawable.current_thunder_clear_night
        "moderate or heavy rain in area with thunder" -> R.drawable.current_thunder_no_sun_night
        "patchy light snow in area with thunder" -> R.drawable.current_thunder_snow_clear_night
        "moderate or heavy snow in area with thunder" -> R.drawable.current_thunder_snow_no_sun_night
        else -> R.drawable.current_default_night
    }
}