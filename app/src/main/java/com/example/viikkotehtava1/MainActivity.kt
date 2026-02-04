package com.example.viikkotehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viikkotehtava1.view.HomeScreen
import com.example.viikkotehtava1.view.CalendarScreen
import com.example.viikkotehtava1.view.SettingsScreen
import com.example.viikkotehtava1.navigation.*
import com.example.viikkotehtava1.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: TaskViewModel = viewModel()
                Scaffold() {
                    NavHost(
                        navController = navController,
                        startDestination = ROUTE_HOME
                    ) {
                        composable(ROUTE_HOME) {
                            HomeScreen(
                                modifier = Modifier,
                                viewModel = viewModel,
                                onNavigateCalendar = { navController.navigate(ROUTE_CALENDAR) },
                                onNavigateSettings = { navController.navigate(ROUTE_SETTINGS) }
                            )
                        }
                        composable(ROUTE_CALENDAR) {
                            CalendarScreen(
                                modifier = Modifier,
                                viewModel = viewModel,
                                onNavigateHome = { navController.navigate(ROUTE_HOME) },
                                onNavigateSettings = { navController.navigate(ROUTE_SETTINGS) }
                            )
                        }
                        composable(ROUTE_SETTINGS) {
                            SettingsScreen(
                                modifier = Modifier,
                                viewModel = viewModel,
                                onNavigateCalendar = { navController.navigate(ROUTE_CALENDAR) },
                                onNavigateHome = { navController.navigate(ROUTE_HOME) }
                            )
                        }
                    }
                }

            }
        }
    }
