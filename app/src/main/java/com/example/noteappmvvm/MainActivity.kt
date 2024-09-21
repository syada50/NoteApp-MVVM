package com.example.noteappmvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteappmvvm.adapter.TodoAdapter
import com.example.noteappmvvm.databinding.ActivityMainBinding
import com.example.noteappmvvm.databinding.ItemTodoBinding
import com.example.noteappmvvm.viewModel.TodoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val todoViewModel:TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        todoViewModel.todoItems.observe(this, Observer {
            binding.recyclerView.adapter = TodoAdapter(it)
        })

    }
}

