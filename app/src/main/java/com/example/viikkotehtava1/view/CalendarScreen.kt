package com.example.viikkotehtava1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.model.Task
import com.example.viikkotehtava1.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(),
    onNavigateHome: () -> Unit,
    onNavigateSettings: () -> Unit
){
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()



    viewModel.sortByDueDate()

    TopAppBar(
        title = { Text("Calendar") },
        actions = {
            IconButton(onClick = onNavigateHome) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Go to home")
            }
            IconButton(onClick = onNavigateSettings) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Go to settings")
            }
        }
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(1) {
            tasks.forEach { task ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .clickable(onClick = { viewModel.selectTask(task) }),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = task.done, onCheckedChange = { viewModel.toggleDone(task) })
                    Text(task.title)
                    Text(task.dueDate)
                    Button(
                        onClick = { viewModel.removeTask(task) }
                    )
                    { Text("Delete") }
                }

            }
        }
    }
    if(selectedTask != null){
        val s: Task? = selectedTask
        DetailScreen(task = s, onClose = { viewModel.closeDialog() } , onUpdate = { viewModel.updateTask(it)})
    }
}