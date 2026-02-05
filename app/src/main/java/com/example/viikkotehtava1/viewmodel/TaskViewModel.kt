package com.example.viikkotehtava1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viikkotehtava1.model.Task
import kotlin.collections.plus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.collections.emptyList

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks
    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask

    val showAddScreen = MutableStateFlow<Boolean>(false)


    init {
        _tasks.value = listOf<Task>(
            Task(1, "kauppa", "käy kaupassa", 1, "25-01-13", false),
            Task(2, "siivoa", "imuroi lattiat", 2, "25-01-20", false),
            Task(3, "lenkki", "käy lenkillä", 3, "25-01-14", false),
            Task(4, "pyykit", "pese pyykit", 4, "25-01-18", false),
            Task(5, "ruoka", "tee ruokaa", 5, "25-01-12", false)
        )
    }

    fun addTask(task: Task){
        _tasks.value = _tasks.value + task
    }

    fun toggleDone(doneTask: Task){
        _tasks.value = _tasks.value.map{
            if(it.id == doneTask.id){
                if(doneTask.done){
                    doneTask.done = false
                }else{
                    doneTask.done = true
                }
                doneTask
            }else{
                it
            }
        }
    }

    fun filterByDone(done: Boolean){
        _tasks.value = _tasks.value.filter { !it.done }
    }

    fun sortByDueDate(){
        _tasks.value = _tasks.value.sortedBy { it.dueDate }
    }

    fun reset(){
        _tasks.value = _tasks.value.sortedBy { it.id }
    }

    fun removeTask(taskToRemove: Task){
        _tasks.value = _tasks.value.filterNot { it.id == taskToRemove.id}
    }

    fun updateTask(updatedTask: Task?){
        _tasks.value = _tasks.value.map{
            if(it.id == updatedTask?.id){
                updatedTask
            }else{
                it
            }
        }
        _selectedTask.value = null
    }

    fun selectTask(task: Task){
        _selectedTask.value = task
    }

    fun closeDialog(){
        _selectedTask.value = null
    }
}