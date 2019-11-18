package com.example.androidmvp.main

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.R
import android.view.LayoutInflater
import android.view.ViewGroup

class MainAdapter(private val items: List<String>, private val listener: Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    interface Listener {
        fun onItemClicked(item: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_item, parent, false) as TextView
        return MainViewHolder(v)
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item
        holder.textView.setOnClickListener { v -> listener.onItemClicked(item) }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class MainViewHolder(var textView: TextView) : RecyclerView.ViewHolder(textView)
}

private fun Any.onItemClicked(item: String) {

}
