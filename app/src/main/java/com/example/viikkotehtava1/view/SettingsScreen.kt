package com.example.viikkotehtava1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        title = { Text("Settings") },
        actions = {
            IconButton(onClick = onNavigateHome) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Go to home")
            }
            IconButton(onClick = onNavigateCalendar) {
                Icon(imageVector = Icons.Default.CalendarMonth, contentDescription = "Go to calendar")
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Coming Soon")
    }

}