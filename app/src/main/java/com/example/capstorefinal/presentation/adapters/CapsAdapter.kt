package com.example.capstorefinal.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstorefinal.data.model.CapModel
import com.example.capstorefinal.databinding.ItemSaleRvBinding

class CapsAdapter(private val capList:List<CapModel>):
    RecyclerView.Adapter<CapsAdapter.ViewHolder>() {

    var onItemClick: ((CapModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSaleRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(capList[position]) {
                binding.brandName.text = this.nameBrand
                binding.costTv.text = this.cost.toString()+"$"
                binding.imageCap.setImageResource(this.image)
                binding.description.text = this.description

            }
        }
    }

    override fun getItemCount(): Int = capList.size


    inner class ViewHolder(val binding: ItemSaleRvBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(capList[position])
            }
        }

    }
}
