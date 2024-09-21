package com.example.noteappmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteappmvvm.databinding.ItemTodoBinding
import com.example.noteappmvvm.model.TodoItem

class TodoAdapter(private val todoItems:List<TodoItem>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    class TodoViewHolder(private val binding: ItemTodoBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:TodoItem){
            binding.noteTitle.text = item.title
            binding.checkCompleted.isChecked = item.isComplete
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoItems[position])
    }
}