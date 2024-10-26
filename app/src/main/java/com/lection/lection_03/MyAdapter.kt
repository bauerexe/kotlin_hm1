package com.lection.lection_03

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val items = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("ADD", "onCreateViewHolder")
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        if (item % 2 == 0) {
            holder.setBackgroundColor(Color.RED)
        } else {
            holder.setBackgroundColor(Color.BLUE)
        }

        Log.d("ADD", "onBindViewHolder")
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(range: Iterable<Int>) {
        items.clear()
        items.addAll(range)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(item: Int) {
        items.add(item)
        notifyDataSetChanged()
    }
}