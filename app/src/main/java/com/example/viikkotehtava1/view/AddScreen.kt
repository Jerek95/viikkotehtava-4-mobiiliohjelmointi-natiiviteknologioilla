package com.example.viikkotehtava1.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.viikkotehtava1.model.Task

@Composable
fun AddScreen(task: Task?, onClose: () -> Unit, onAdd: (Task) -> Unit){
    var title by remember { mutableStateOf(task!!.title) }
    var description by remember { mutableStateOf(task!!.description) }
    var dueDate by remember { mutableStateOf(task!!.dueDate) }

    AlertDialog(
        onDismissRequest = onClose,
        title = { Text("Add Task") },
        text = {
            Column{
                TextField(value = title, onValueChange = { title = it  }, label = { Text("Title") })
                TextField(value = description, onValueChange = { description = it  }, label = { Text("Description") })
                TextField(value = dueDate, onValueChange = { dueDate = it  }, label = { Text("DueDate") })
            }
        },
        confirmButton = {
            Button(
                onClick = { onAdd(task!!.copy(title = title, description = description, dueDate = dueDate)); onClose() }

            ) {
                Text("Save")
            } },
        dismissButton = {
            Button(
                onClick = { onClose()}
            ) {
                Text("Close")
            }
        }
    )
}