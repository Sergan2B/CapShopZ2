package com.example.capstorefinal.presentation.fragments.detailScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstorefinal.R

class ViewPagerAdapter(private val imgList:List<Int> ):
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_image_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(imgList[position])
    }

    override fun getItemCount(): Int  = imgList.size


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.vp_image_ev)
    }
}