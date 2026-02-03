package com.example.viikkotehtava1.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.viewmodel.TaskViewModel

@Composable
fun CalendarScreen(modifier: Modifier = Modifier, viewModel: TaskViewModel = viewModel()){
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()

    /*
    yläpalkki, jossa ikonit joilla liikutaan sivujen välillä

    tulostetaan tehtävät listana
     */
}