package com.example.androidreduxrxpoc

data class AppState(
    val visibilityFilter: VisibilityFilter = VisibilityFilter.SHOW_ALL,
    val todos: List<Todo> = listOf(
        Todo(
            text = "Consider using Redux",
            completed = true
        ),
        Todo(
            text = "Keep all state in a single tree",
            completed = false
        )
    )
)

fun visibilityFilterReducer(state: VisibilityFilter, action: Any) =
    when (action) {
        is SetVisibilityFilter -> action.filter
        else -> state
    }

fun todosReducer(state: List<Todo>, action: Any) =
    when (action) {
        is AddTodo -> state + Todo(action.text)
        is ToggleTodo -> state.mapIndexed { index, todo ->
            if (index == action.index) {
                todo.copy(completed = !todo.completed)
            } else {
                todo
            }
        }
        else -> state
    }

fun rootReducer(state: AppState, action: Any) = AppState(
    todos = todosReducer(state.todos, action),
    visibilityFilter = visibilityFilterReducer(state.visibilityFilter, action)
)