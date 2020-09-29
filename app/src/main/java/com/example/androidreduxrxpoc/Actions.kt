package com.example.androidreduxrxpoc

data class AddTodo(val text: String)
data class ToggleTodo(val index: Int)
data class SetVisibilityFilter(val filter: VisibilityFilter)

enum class VisibilityFilter {
    SHOW_ALL,
    SHOW_COMPLETED,
    SHOW_ACTIVE
}

data class Todo(
    val text: String,
    val completed: Boolean = false
)