package com.example.basictodolist

data class Todo(
    val title: String,
    var isChecked: Boolean = false
)