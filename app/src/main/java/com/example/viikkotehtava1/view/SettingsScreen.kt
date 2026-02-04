package com.example.viikkotehtava1.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.viewmodel.TaskViewModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(),
    onNavigateHome: () -> Unit,
    onNavigateCalendar: () -> Unit
){
    /*
    yläpalkki
     */

    TopAppBar(
        title = { Text("Calendar") },
        navigationIcon = {
            IconButton(onClick = onNavigateHome) {
                Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Go to home")
            }
            IconButton(onClick = onNavigateCalendar) {
                Icon(Icons.AutoMirrored.Filled.calendar_month, contentDescription = "Go to calendar")
            }
        }
    )
}