package com.example.androidreduxrxpoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidreduxrxpoc.R
import com.example.androidreduxrxpoc.actions.Todo
import com.example.androidreduxrxpoc.stores.store

class ItemAdapter(private val context: Context, private val dataset: List<Todo>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(todo: Todo) {
            val textView: TextView = view.findViewById(R.id.item_title)
            textView.text = "• ${todo.text}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(store.state.todos[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}