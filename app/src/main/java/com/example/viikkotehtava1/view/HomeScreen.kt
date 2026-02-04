package com.example.viikkotehtava1.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikkotehtava1.model.Task
import com.example.viikkotehtava1.viewmodel.TaskViewModel
import androidx.compose.runtime.collectAsState



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(),
    onNavigateCalendar: () -> Unit,
    onNavigateSettings: () -> Unit
){
    val tasks by viewModel.tasks.collectAsState()
    val selectedTask by viewModel.selectedTask.collectAsState()
    var text by remember { mutableStateOf("") }


    TopAppBar(
        title = { Text("Calendar") },
        navigationIcon = {
            IconButton(onClick = onNavigateCalendar) {
                Icon(Icons.AutoMirrored.Filled.calendar_month, contentDescription = "Go to calendar")
            }
            IconButton(onClick = onNavigateSettings) {
                Icon(Icons.AutoMirrored.Filled.Settings, contentDescription = "Go to settings")
            }
        }
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(1){
            tasks.forEach { task ->
                Row(
                    modifier = Modifier.fillMaxWidth().clickable(onClick = {viewModel.selectTask(task)}),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = task.done, onCheckedChange = {viewModel.toggleDone(task)})
                    Text(task.title)
                    Button(
                        onClick = {viewModel.removeTask(task)}
                    )
                    { Text("Delete") }
                }

            }

            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter name") }
                )
                Button(
                    onClick = {viewModel.addTask(
                        Task(viewModel.tasks.value.size + 1, text, text, 1, "", false)
                    )}
                )
                { Text("Add Task")}
                Button(onClick = { viewModel.filterByDone(false) }) {
                    Text("Filter By Done")
                }
                Button(onClick = { viewModel.sortByDueDate() }) {
                    Text("Sort By Due Date")
                }
                Button(onClick = { viewModel.reset() }) {
                    Text("Reset")
                }
            }
        }
    }
    if(selectedTask != null){
        val s: Task? = selectedTask
        DetailScreen(task = s, onClose = { viewModel.closeDialog() } , onUpdate = { viewModel.updateTask(it)})
    }

}