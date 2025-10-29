package com.example.redsky


import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
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
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource


class MainActivity : ComponentActivity() {


    private val mainViewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RedSkyTheme {
                MaterialTheme {
                    var coordinates by remember { mutableStateOf<String?>(null) }

                    GetLocation { newCoordinates ->
                        coordinates = newCoordinates
                    }

                    LaunchedEffect(coordinates) {
                        coordinates?.let {
                            mainViewModel.fetchWeather(
                                apiKey = "40cbff191a3d42bb976162949251610",
                                location = it,
                                days = 3
                            )
                        }
                    }
                    DisplayUI(mainViewModel)
               }
            }
        }
    }
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun GetLocation(onLocationReceived: (String) -> Unit) {
        // Remember the permission state(asking for Fine location)
        val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionState.status.isGranted) {
            Log.i("TESTING", "Hurray, permission granted!")

            // Get Location
            val currentContext = LocalContext.current
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(currentContext)

            if (ContextCompat.checkSelfPermission(
                    currentContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED)
            {
                val cancellationTokenSource = CancellationTokenSource()

                Log.i("TESTING", "Requesting location...")

                fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, cancellationTokenSource.token)
                    .addOnSuccessListener { location ->
                        if (location != null) {
                            val lat = location.latitude.toString()
                            val lng = location.longitude.toString()

                            Log.i("TESTING", "Success: $lat $lng")

                            val coordinates = "$lat,$lng"

                            onLocationReceived(coordinates)
                        }
                        else {
                            Log.i("TESTING", "Problem encountered: Location returned null")
                        }
                    }
            }
        }
        else {
            // Run a side-effect (coroutine) to get permission. The permission popup.
            LaunchedEffect(permissionState){
                permissionState.launchPermissionRequest()
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
//fin

