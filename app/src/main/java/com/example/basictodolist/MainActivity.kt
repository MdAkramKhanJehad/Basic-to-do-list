
package com.example.basictodolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvToDoItems.adapter = todoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            var todoTitle = etToDoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                var todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etToDoTitle.text.clear()
            }
        }

        btnDeleteTodos.setOnClickListener{
            todoAdapter.deletedonetodos()
        }

    }
}