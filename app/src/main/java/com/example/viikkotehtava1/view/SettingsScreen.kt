package com.example.viikkotehtava1.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(),
    onNavigateHome: () -> Unit,
    onNavigateCalendar: () -> Unit
){


    TopAppBar(
        title = { Text("Calendar") },
        navigationIcon = {
            IconButton(onClick = onNavigateHome) {
                Icon(Icons.Default.Home, contentDescription = "Go to home")
            }
            IconButton(onClick = onNavigateCalendar) {
                Icon(Icons.Default.CalendarMonth, contentDescription = "Go to calendar")
            }
        }
    )
}