package com.example.capstorefinal.presentation.fragments.orderScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstorefinal.data.model.OrderModel
import com.example.capstorefinal.databinding.ItemOrderBinding

class OrderAdapter(private val orderList: MutableList<OrderModel>):RecyclerView.Adapter<OrderAdapter.ViewHolder>(){


    var onItemCLick:((OrderModel)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(orderList[position]) {
               binding.orderNumberTv.text = this.orderNumber.toString()
               binding.dateNumTv.text = this.orderDate.toString()
                binding.statusNumTv.text = this.orderStatus
            }
        }
    }

    override fun getItemCount(): Int  = orderList.size

    inner  class ViewHolder(val binding: ItemOrderBinding) :RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                onItemCLick?.invoke(orderList[adapterPosition])
            }
        }
    }

}