package com.example.wisataku2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class WisataAdapter(private val context: Context, private val wisataList: ArrayList<Wisata>) : RecyclerView.Adapter<WisataAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_wisata, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = wisataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = wisataList[position]
        holder.wisataImage.setImageResource(currentItem.wisataImage)
        holder.tvHeading.text = currentItem.heading

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("WISATA_NAME", currentItem.heading)
            intent.putExtra("WISATA_DESCRIPTION", context.resources.getStringArray(R.array.wisata_descriptions)[position])
            intent.putExtra("WISATA_IMAGE", currentItem.wisataImage)
            intent.putExtra("wisataWebsite", context.resources.getStringArray(R.array.wisata_websites)[position])
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wisataImage: ShapeableImageView = itemView.findViewById(R.id.wisata_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    }
}