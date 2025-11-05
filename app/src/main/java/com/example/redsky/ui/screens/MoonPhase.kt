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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.redsky.MainViewModel
import com.example.redsky.ui.theme.MoonBG
import com.example.redsky.utilities.getMoonPhaseImage
import java.time.LocalDate
import kotlin.random.Random


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MoonPhase(mainViewModel: MainViewModel){
    val weather by mainViewModel.weather.collectAsState()

    if (weather == null){
        Text("Loading weather data...",
            fontSize = 20.sp,
            color = Color.White
        )
        return
    }

    val moonImage = getMoonPhaseImage(weather?.forecast?.forecastDay?.firstOrNull()?.astro!!.moonPhase)


    fun getDailyQuote(): String {
        val quotes = listOf(
            "If the moon smiled, she would resemble you. You leave the same impression. Of something beautiful, but annihilating. Both of you are great light borrowers. —Sylvia Plath",
            "I’d rather live in a world where I get to love the moon than in one where I don’t, even if the moon won’t return the feeling. —Alex London",
            "Don’t worry if you’re making waves just by being yourself. The moon does it all the time. —Scott Stabile",
            "The moon was reigning all over their world, glowing its full splendor to all those willing to look up. —Irina Serban",
            "Go further than you planned. Ask for the moon. You will be surprised how often you get it. —Paulo Coelho",
            "The moon is the reflection of your heart, and moonlight is the twinkle of your love. —Debasish Mridha",
            "Yours is the light by which my spirit’s born: — you are my sun, my moon, and all my stars. —E.E. Cummings",
            "Always remember we are under the same sky, looking at the same moon. —Maxine Lee",
            "Let the moon teach you the art of being beautiful and lonely at the same time. — Anand Thakur",
            "Just like moons and like suns, with the certainty of tides, just like hopes springing high, still I’ll rise. —Maya Angelou",
            "Be both soft and wild. Just like the moon. Or the storm. Or the sea. —Victoria Erickson",
            "The moon was so beautiful that the ocean held up a mirror. —Ani DiFranco",
            "But even when the moon looks like it’s waning…it’s actually never changing shape. Don’t ever forget that. —Ai Yazawa",
            "Three things cannot be long hidden: the sun, the moon, and the truth. —Buddha",
            "Be the moon and inspire people, even when you’re far from full. —K. Tolnoe",
            "I like to think that the moon is there, even if I am not looking at it. —Albert Einstein",
            "Go slowly, my lovely moon, go slowly. —Khaled Hosseini",
            "With freedom, books, flowers, and the moon, who could not be happy. —Oscar Wilde",
            "There are nights when the wolves are silent and only the moon howls. —George Carlin",
            "The moon is friend for the lonesome to talk to. —Carl Sandburg"
        )
        val today = weather?.forecast?.forecastDay?.firstOrNull()!!.date
        val randomIndex = Random(today).nextInt(quotes.size)

        return quotes[randomIndex]
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MoonBG)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Image(
                painter= painterResource(id = moonImage),
                contentDescription = weather?.forecast?.forecastDay?.firstOrNull()?.astro?.moonPhase,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "${weather?.forecast?.forecastDay?.firstOrNull()?.astro?.moonPhase}",
                color = Color.White,
                fontSize = 44.sp
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = getDailyQuote(),
                color = Color.White,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}

//commentforpush