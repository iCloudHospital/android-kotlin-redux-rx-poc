package com.example.androidreduxrxpoc

// Create actions
data class AddTodo(val text: String)
data class ToggleTodo(val index: Int)
data class SetVisibilityFilter(val filter: VisibilityFilter)

// Create additional classes
enum class VisibilityFilter {
    SHOW_ALL,
    SHOW_COMPLETED,
    SHOW_ACTIVE
}

data class Todo(
    val text: String,
    val completed: Boolean = false
)