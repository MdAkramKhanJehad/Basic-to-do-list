package com.example.basictodolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_items.view.*

class TodoAdapter ( private val todos: MutableList<Todo>
    ): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    fun addTodo(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }
    
    fun deletedonetodos(){
        todos.removeAll{ todo->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isCheked: Boolean){
        if(isCheked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_items,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        var curTodo = todos[position]

        holder.itemView.apply {
            tvToDoTitle.text = curTodo.title
            cbDone.isChecked = curTodo.isChecked
            toggleStrikeThrough(tvToDoTitle, curTodo.isChecked)
            cbDone.setOnCheckedChangeListener{_, isChecked->
                toggleStrikeThrough(tvToDoTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked

            }

        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}