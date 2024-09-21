package com.example.noteappmvvm.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import  com.example.noteappmvvm.model.TodoItem
import com.example.noteappmvvm.repository.TodoRepository

class TodoViewModel:ViewModel() {
    private val repository = TodoRepository()

    private val _todoItems = MutableLiveData<List<TodoItem>>()

    val todoItems:LiveData<List<TodoItem>> = _todoItems

    init {
        _todoItems.value = repository.getTodoItems()
    }

    fun markItemAsCompleted(id:Int){
        val updatedList = todoItems.value?.map {
            if(it.id == id){
                it.copy(isComplete = true)
            }else{
                it
            }
        }
        _todoItems.value = updatedList
    }
}