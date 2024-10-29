package com.lection.lection_03

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    val items = ArrayList<Int>()
    val deletedItems = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
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

        holder.itemView.setOnClickListener {
            removeItem(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(newItem: Int) {
        if (deletedItems.isNotEmpty()) {
            val restoredItem = deletedItems.removeAt(0)
            items.add(restoredItem)
        } else {
            items.add(newItem)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(range: Iterable<Int>) {
        items.clear()
        items.addAll(range)
        notifyDataSetChanged()
    }

    private fun removeItem(position: Int) {
        if (position in items.indices) {
            val removedItem = items.removeAt(position)
            deletedItems.add(removedItem)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size - position)
        }
    }
}
