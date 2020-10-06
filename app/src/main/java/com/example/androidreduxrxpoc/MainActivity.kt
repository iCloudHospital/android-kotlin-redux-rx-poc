package com.example.androidreduxrxpoc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidreduxrxpoc.actions.AddTodo
import com.example.androidreduxrxpoc.adapter.ItemAdapter
import com.example.androidreduxrxpoc.data.Datasource
import com.example.androidreduxrxpoc.stores.store
import org.reduxkotlin.StoreSubscription

class MainActivity : AppCompatActivity() {
    private lateinit var storeSubscription: StoreSubscription
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeSubscription = store.subscribe { Datasource().loadTodos() }
        var myDataset = store.state.todos
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        val button: Button = findViewById(R.id.btn_add)
        button.setOnClickListener {
            addTodo()
            myDataset = store.state.todos
            recyclerView.adapter = ItemAdapter(this, myDataset)
        }
        recyclerView.adapter = ItemAdapter(this, myDataset)
    }
    private fun addTodo() {
        val textBox: EditText = findViewById(R.id.text_add_todo)
        val text = textBox.text.toString()
        store.dispatch(AddTodo(text))
        textBox.text.clear()
    }
}

