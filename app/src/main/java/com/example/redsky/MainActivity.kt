package com.example.redsky

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.redsky.data.PlaceholderCurrentWeather
import com.example.redsky.data.PlaceholderData
import com.example.redsky.data.PlaceholderData.forecastSample


import com.example.redsky.ui.screens.CurrentWeather
import com.example.redsky.ui.screens.DailyForecast
import com.example.redsky.ui.screens.ForecastList
import com.example.redsky.ui.theme.RedSkyTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DisplayUI() {
    val navController = rememberNavController()
    var selectedItem by remember {mutableIntStateOf(0)}

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("Halifax, Nova Scotia")
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            )
            {
                NavigationBarItem(
                    label = {
                        Text("Current")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.sailing_boat),
                            contentDescription = "Boat Icon"
                        )
                    },
                    selected = selectedItem == 0,
                    onClick = {
                        selectedItem = 0
                        navController.navigate("Current")
                    }
                )

                NavigationBarItem(
                    label = {
                        Text("Forecast")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.telescope),
                            contentDescription = "telescope Icon"
                        )
                    },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem= 1
                        navController.navigate("Forecast")
                    }
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
            composable(route = "Current")
            {
                CurrentWeather(PlaceholderCurrentWeather.sampleCurrent)
            }
            composable(route = "Forecast")
            {
                ForecastList(PlaceholderData.forecastSample)
            }
        }
    }
}




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedSkyTheme {
                MaterialTheme {
                    DisplayUI()
               }

            }
        }
    }
}

