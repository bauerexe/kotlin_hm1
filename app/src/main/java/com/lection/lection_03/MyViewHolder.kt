package com.lection.lection_03

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val text: TextView = view.findViewById(R.id.text_1)
    private val image: ImageView = view.findViewById(R.id.image_view)

    fun bind(number: Int) {
        text.text = "$number"
    }

    fun setBackgroundColor(color: Int) {
        image.setBackgroundColor(color)
    }
}
