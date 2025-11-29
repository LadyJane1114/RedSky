package com.example.redsky.utilities

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
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
import com.example.redsky.ui.theme.LSnowClearNight
import com.example.redsky.ui.theme.LSnowSunDay
import com.example.redsky.ui.theme.ModRainNoSunNight
import com.example.redsky.ui.theme.PartCloudDay
import com.example.redsky.ui.theme.PartCloudNight
import com.example.redsky.ui.theme.Sunset
import com.example.redsky.ui.theme.ThunderDay
import com.example.redsky.ui.theme.ThunderNight
import com.example.redsky.ui.theme.ThunderSnowDay
import com.example.redsky.ui.theme.ThunderSnowNight
import com.example.redsky.ui.theme.TorrentialDay
import com.example.redsky.ui.theme.TorrentialNight
import okhttp3.internal.UTC
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


fun getDayBGColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "cloudy" -> CloudyDay
        "partly cloudy" -> PartCloudDay
        "overcast" -> CloudyDay
        "mist" -> PartCloudDay
        "patchy rain nearby" -> LRainDay
        "patchy light rain" -> LRainDay
        "patchy snow nearby" -> LSnowSunDay
        "patchy sleet nearby" -> LSnowSunDay
        "patchy freezing drizzle nearby" -> LSnowSunDay
        "thundery outbreaks in nearby" -> ThunderDay
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
        "light freezing rain" -> LSnowSunDay
        "moderate or heavy freezing rain" -> LRainNoSunDay
        "light sleet" -> LRainNoSunDay
        "moderate or heavy sleet" -> LRainNoSunDay
        "patchy light snow" -> LSnowSunDay
        "light snow" -> LRainNoSunDay
        "patchy moderate snow" -> LRainNoSunDay
        "moderate snow" -> LRainNoSunDay
        "patchy heavy snow" -> LSnowSunDay
        "heavy snow" -> CloudyDay
        "ice pellets" -> LRainNoSunDay
        "light rain shower" -> LRainDay
        "moderate or heavy rain shower" -> PartCloudDay
        "torrential rain shower" -> TorrentialDay
        "light sleet showers" -> LSnowSunDay
        "moderate or heavy sleet showers" -> LRainNoSunDay
        "light snow showers" -> LSnowSunDay
        "moderate or heavy snow showers" -> LSnowSunDay
        "light showers of ice pellets" -> LSnowSunDay
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
        "sunny" -> Sunset
        "cloudy" -> CloudyNight
        "partly cloudy" -> PartCloudNight
        "overcast" -> CloudyNight
        "mist" -> PartCloudNight
        "patchy rain nearby" -> LRainNight
        "patchy light rain" -> LRainNight
        "patchy snow nearby" -> LSnowClearNight
        "patchy sleet nearby" -> LSnowClearNight
        "patchy freezing drizzle nearby" -> LSnowClearNight
        "thundery outbreaks in nearby" -> ThunderNight
        "blowing snow" -> Blizzard
        "blizzard" -> Blizzard
        "fog" -> CloudyNight
        "freezing fog" -> CloudyNight
        "patchy light drizzle" -> ModRainNoSunNight
        "light drizzle" -> ModRainNoSunNight
        "freezing drizzle" -> LRainNoSunNight
        "heavy freezing drizzle" -> CloudyNight
        "light rain" -> LRainNoSunNight
        "moderate rain at times" -> LRainNight
        "moderate rain" -> LRainNoSunNight
        "heavy rain at times" -> LRainNight
        "heavy rain" -> CloudyNight
        "light freezing rain" -> LSnowClearNight
        "moderate or heavy freezing rain" -> LRainNoSunNight
        "light sleet" -> LRainNoSunNight
        "moderate or heavy sleet" -> LRainNoSunNight
        "patchy light snow" -> LSnowClearNight
        "light snow" -> LRainNoSunNight
        "patchy moderate snow" -> LRainNoSunNight
        "moderate snow" -> LRainNoSunNight
        "patchy heavy snow" -> LSnowClearNight
        "heavy snow" -> CloudyNight
        "ice pellets" -> LRainNoSunNight
        "light rain shower" -> LRainNight
        "moderate or heavy rain shower" -> LRainNight
        "torrential rain shower" -> TorrentialNight
        "light sleet showers" -> LSnowClearNight
        "moderate or heavy sleet showers" -> LRainNoSunNight
        "light snow showers" -> LSnowClearNight
        "moderate or heavy snow showers" -> LSnowClearNight
        "light showers of ice pellets" -> LSnowClearNight
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
        "sunny" -> Color.Black
        "cloudy" -> Color.White
        "partly cloudy" -> Color.Black
        "overcast" -> Color.White
        "mist" -> Color.Black
        "patchy rain nearby" -> Color.Black
        "patchy light rain" -> Color.Black
        "patchy snow nearby" -> Color.Black
        "patchy sleet nearby" -> Color.Black
        "patchy freezing drizzle nearby" -> Color.Black
        "thundery outbreaks in nearby" -> Color.White
        "blowing snow" -> Color.White
        "blizzard" -> Color.White
        "fog" -> Color.Black
        "freezing fog" -> Color.White
        "patchy light drizzle" -> Color.Black
        "light drizzle" -> Color.Black
        "freezing drizzle" -> Color.Black
        "heavy freezing drizzle" -> Color.White
        "light rain" -> Color.Black
        "moderate rain at times" -> Color.Black
        "moderate rain" -> Color.Black
        "heavy rain at times" -> Color.Black
        "heavy rain" -> Color.White
        "light freezing rain" -> Color.Black
        "moderate or heavy freezing rain" -> Color.Black
        "light sleet" -> Color.Black
        "moderate or heavy sleet" -> Color.Black
        "patchy light snow" -> Color.Black
        "light snow" -> Color.Black
        "patchy moderate snow" -> Color.Black
        "moderate snow" -> Color.Black
        "patchy heavy snow" -> Color.Black
        "heavy snow" -> Color.White
        "ice pellets" -> Color.Black
        "light rain shower" -> Color.Black
        "moderate or heavy rain shower" -> Color.Black
        "torrential rain shower" -> Color.White
        "light sleet showers" -> Color.Black
        "moderate or heavy sleet showers" -> Color.Black
        "light snow showers" -> Color.Black
        "moderate or heavy snow showers" -> Color.Black
        "light showers of ice pellets" -> Color.Black
        "moderate or heavy showers of ice pellets" -> Color.Black
        "patchy light rain in area with thunder" -> Color.White
        "moderate or heavy rain in area with thunder" -> Color.White
        "patchy light snow in area with thunder" -> Color.White
        "moderate or heavy snow in area with thunder" -> Color.White
        else -> Color.Black
    }
}

fun getForecastBGColor(condition:String): Color {
    return when (condition.lowercase()) {
        "sunny" -> SunnyBlue
        "cloudy " -> CloudyDay
        "partly cloudy " -> PartCloudDay
        "overcast " -> CloudyDay
        "mist" -> PartCloudDay
        "patchy rain nearby" -> LRainDay
        "patchy light rain" -> LRainDay
        "patchy snow nearby" -> LSnowSunDay
        "patchy sleet nearby" -> LSnowSunDay
        "patchy freezing drizzle nearby" -> LSnowSunDay
        "thundery outbreaks in nearby" -> ThunderDay
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
        "light freezing rain" -> LSnowSunDay
        "moderate or heavy freezing rain" -> LRainNoSunDay
        "light sleet" -> LRainNoSunDay
        "moderate or heavy sleet" -> LRainNoSunDay
        "patchy light snow" -> LSnowSunDay
        "light snow" -> LRainNoSunDay
        "patchy moderate snow" -> LRainNoSunDay
        "moderate snow" -> LRainNoSunDay
        "patchy heavy snow" -> LSnowSunDay
        "heavy snow" -> CloudyDay
        "ice pellets" -> LRainNoSunDay
        "light rain shower" -> LRainDay
        "moderate or heavy rain shower" -> PartCloudDay
        "torrential rain shower" -> TorrentialDay
        "light sleet showers" -> LSnowSunDay
        "moderate or heavy sleet showers" -> LRainNoSunDay
        "light snow showers" -> LSnowSunDay
        "moderate or heavy snow showers" -> LSnowSunDay
        "light showers of ice pellets" -> LSnowSunDay
        "moderate or heavy showers of ice pellets" -> LRainNoSunDay
        "patchy light rain in area with thunder" -> ThunderDay
        "moderate or heavy rain in area with thunder" -> ThunderDay
        "patchy light snow in area with thunder" -> ThunderSnowDay
        "moderate or heavy snow in area with thunder" -> ThunderSnowDay
        else -> Color.White
    }
}
fun getForecastTextColor(condition: String): Color {
    return when (condition.lowercase()) {
        "sunny" -> Color.Black
        "cloudy " -> Color.White
        "partly cloudy " -> Color.Black
        "overcast " -> Color.White
        "mist" -> Color.Black
        "patchy rain nearby" -> Color.Black
        "patchy light rain" -> Color.Black
        "patchy snow nearby" -> Color.Black
        "patchy sleet nearby" -> Color.Black
        "patchy freezing drizzle nearby" -> Color.Black
        "thundery outbreaks in nearby" -> Color.White
        "blowing snow" -> Color.White
        "blizzard" -> Color.White
        "fog" -> Color.Black
        "freezing fog" -> Color.White
        "patchy light drizzle" -> Color.Black
        "light drizzle" -> Color.Black
        "freezing drizzle" -> Color.Black
        "heavy freezing drizzle" -> Color.White
        "light rain" -> Color.Black
        "moderate rain at times" -> Color.Black
        "moderate rain" -> Color.Black
        "heavy rain at times" -> Color.Black
        "heavy rain" -> Color.White
        "light freezing rain" -> Color.Black
        "moderate or heavy freezing rain" -> Color.Black
        "light sleet" -> Color.Black
        "moderate or heavy sleet" -> Color.Black
        "patchy light snow" -> Color.Black
        "light snow" -> Color.Black
        "patchy moderate snow" -> Color.Black
        "moderate snow" -> Color.Black
        "patchy heavy snow" -> Color.Black
        "heavy snow" -> Color.White
        "ice pellets" -> Color.Black
        "light rain shower" -> Color.Black
        "moderate or heavy rain shower" -> Color.Black
        "torrential rain shower" -> Color.White
        "light sleet showers" -> Color.Black
        "moderate or heavy sleet showers" -> Color.Black
        "light snow showers" -> Color.Black
        "moderate or heavy snow showers" -> Color.Black
        "light showers of ice pellets" -> Color.Black
        "moderate or heavy showers of ice pellets" -> Color.Black
        "patchy light rain in area with thunder" -> Color.White
        "moderate or heavy rain in area with thunder" -> Color.White
        "patchy light snow in area with thunder" -> Color.White
        "moderate or heavy snow in area with thunder" -> Color.White
        else -> Color.Black
    }
}
//fun getNightTextColor(condition: String): Color {
//    return when (condition.lowercase()) {
//        "clear" -> Color.White
//        "cloudy" -> Color.White
//        "partly cloudy" -> Color.White
//        "overcast" -> Color.White
//        "mist" -> Color.White
//        "patchy rain nearby" -> Color.White
//        "patchy light rain" -> Color.White
//        "patchy snow nearby" -> Color.White
//        "patchy sleet nearby" -> Color.White
//        "patchy freezing drizzle nearby" -> Color.White
//        "thundery outbreaks in nearby" -> Color.White
//        "blowing snow" -> Color.White
//        "blizzard" -> Color.White
//        "fog" -> Color.White
//        "freezing fog" -> Color.White
//        "patchy light drizzle" -> Color.White
//        "light drizzle" -> Color.White
//        "freezing drizzle" -> Color.White
//        "heavy freezing drizzle" -> Color.White
//        "light rain" -> Color.White
//        "moderate rain at times" -> Color.White
//        "moderate rain" -> Color.White
//        "heavy rain at times" -> Color.White
//        "heavy rain" -> Color.White
//        "light freezing rain" -> Color.White
//        "moderate or heavy freezing rain" -> Color.White
//        "light sleet" -> Color.White
//        "moderate or heavy sleet" -> Color.White
//        "patchy light snow" -> Color.White
//        "light snow" -> Color.White
//        "patchy moderate snow" -> Color.White
//        "moderate snow" -> Color.White
//        "patchy heavy snow" -> Color.White
//        "heavy snow" -> Color.White
//        "ice pellets" -> Color.White
//        "light rain shower" -> Color.White
//        "moderate or heavy rain shower" -> Color.White
//        "torrential rain shower" -> Color.White
//        "light sleet showers" -> Color.White
//        "moderate or heavy sleet showers" -> Color.White
//        "light snow showers" -> Color.White
//        "moderate or heavy snow showers" -> Color.White
//        "light showers of ice pellets" -> Color.White
//        "moderate or heavy showers of ice pellets" -> Color.White
//        "patchy light rain in area with thunder" -> Color.White
//        "moderate or heavy rain in area with thunder" ->  Color.White
//        "patchy light snow in area with thunder" -> Color.White
//        "moderate or heavy snow in area with thunder" -> Color.White
//        else -> Color.White
//    }
//}
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
        "sunny" -> R.drawable.current_sunset
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


// Moon Functions
@DrawableRes
fun getMoonPhaseImage(moonPhase:String):Int {
    return when (moonPhase.lowercase()) {
        "new moon" -> R.drawable.moon_new_moon
        "waxing crescent" -> R.drawable.moon_waxing_crescent
        "first quarter" -> R.drawable.moon_first_quarter
        "waxing gibbous" -> R.drawable.moon_waxing_gibbous
        "full moon" -> R.drawable.moon_full_moon
        "waning gibbous" -> R.drawable.moon_waning_gibbous
        "last quarter" -> R.drawable.moon_third_quarter
        "waning crescent" -> R.drawable.moon_waning_crescent
        else -> R.drawable.current_default_night
    }
}






// Date Conversion
@RequiresApi(Build.VERSION_CODES.O)
fun convertDate(epochSeconds: Long): String {
    val instant = Instant.ofEpochSecond(epochSeconds);

    val formatter = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy").withZone(ZoneOffset.UTC)
    return formatter.format(instant)
}