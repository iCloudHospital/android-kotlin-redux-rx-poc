package com.example.androidreduxrxpoc.data

import com.example.androidreduxrxpoc.actions.Todo
import com.example.androidreduxrxpoc.stores.store

class Datasource {
    fun loadTodos(): List<Todo> {
        return store.state.todos
    }
}