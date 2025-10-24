package com.example.redsky


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.redsky.models.MyLocation
import com.example.redsky.models.Weather
import com.example.redsky.ui.screens.CurrentWeather
import com.example.redsky.ui.screens.ForecastList
import com.example.redsky.ui.theme.BannerRed
import com.example.redsky.ui.theme.BannerText
import com.example.redsky.ui.theme.RedSkyTheme
import com.example.redsky.ui.theme.Sunrise



class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainViewModel.fetchWeather(
            apiKey = "40cbff191a3d42bb976162949251610",
            location = "Halifax",
            days = 3
        )

        setContent {
            RedSkyTheme {
                MaterialTheme {
                    DisplayUI(mainViewModel)
               }
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun DisplayUI(mainViewModel: MainViewModel) {
        val navController = rememberNavController()
        var selectedItem by remember {mutableIntStateOf(0)
        }
        val weatherState by mainViewModel.weather.collectAsState()

        Scaffold (
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = BannerRed,
                        titleContentColor = BannerText
                    ),
                    title = {
                        Column {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination?.route
                            val title = when (currentDestination) {
                                "Forecast" -> "Weekly Forecast"
                                "Current" -> "Current Weather"
                                else -> null
                            }
                            title?.let{
                                Text(it,
                                    fontSize = 32.sp)
                            }
                            Text (weatherState?.myLocation.let
                            {
                                "${it?.name}, ${it?.region}"
                            },
                                fontSize = 22.sp,
                                modifier = Modifier.padding(5.dp))
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = BannerRed,
                    contentColor = BannerText
                )
                {
                    NavigationBarItem(
                        label = {
                            Text("Current",
                                fontSize = 18.sp)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.nav_sailing_boat),
                                contentDescription = "Boat Icon",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                        selected = selectedItem == 0,
                        onClick = {
                            selectedItem = 0
                            navController.navigate("Current")
                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = BannerText,
                            unselectedIconColor = BannerText,
                            selectedTextColor = BannerText,
                            unselectedTextColor = BannerText,
                            selectedIndicatorColor = Sunrise,
                            disabledIconColor = Transparent,
                            disabledTextColor = BannerText,
                        )
                    )

                    NavigationBarItem(
                        label = {
                            Text("Forecast",
                                fontSize = 18.sp)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.nav_telescope),
                                contentDescription = "telescope Icon",
                                modifier = Modifier.size(40.dp)
                            )
                        },
                        selected = selectedItem == 1,
                        onClick = {
                            selectedItem= 1
                            navController.navigate("Forecast")
                        },
                        colors = NavigationBarItemColors(
                            selectedIconColor = BannerText,
                            unselectedIconColor = BannerText,
                            selectedTextColor = BannerText,
                            unselectedTextColor = BannerText,
                            selectedIndicatorColor = Sunrise,
                            disabledIconColor = Transparent,
                            disabledTextColor = BannerText,
                        )
                    )
                }
            }
        )
        { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "Current",
                modifier = Modifier.padding(innerPadding)
            )
            {
                composable("Current")
                {
                    CurrentWeather(mainViewModel)
                }
                composable("Forecast")
                {
                    ForecastList(mainViewModel)
                }
            }
        }
    }
}
//fin

