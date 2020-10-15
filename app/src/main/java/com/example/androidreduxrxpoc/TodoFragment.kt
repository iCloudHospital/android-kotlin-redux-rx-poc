package com.example.androidreduxrxpoc

import com.airbnb.mvrx.*
import com.example.androidreduxrxpoc.actions.Todo
import com.example.androidreduxrxpoc.stores.store

data class TodosState(val todos: List<Todo> = listOf()) : MvRxState

class TodosViewModel( state: TodosState ) : BaseMvRxViewModel<TodosState>(state, debugMode = true) {
    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        setState { copy(todos = store.state.todos)}
    }

}

class TodoFragment : BaseMvRxFragment() {
    private val viewModel: TodosViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) { state ->

    }
}
