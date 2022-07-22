package com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.capstorefinal.R
import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.presentation.ui.tabLayout.tabAdapter.AdapterForFirstFragment3.ViewHolder3
import com.example.capstorefinal.utils.ShopItemDiffCallback

class AdapterForFirstFragment3 : ListAdapter<Cap, ViewHolder3>(ShopItemDiffCallback()) {
    var onCapItemClickListener: ((Cap) -> Unit)? = null
    var onCapItemLongClickListener: ((Cap) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder3 {
        val layout = R.layout.item_3_discount
        return ViewHolder3(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder3, position: Int) {
        val cap = getItem(position)
        holder.tvCompany.text = cap.companyName
        holder.tvSeries.text = cap.seriesName
        if (cap.statusDiscount) {
            holder.tvOldCost.text = cap.oldCost.toString()
            holder.tvOldCost.setTextColor(R.color.custom_black_30percent)
            holder.tvNewCost.text = (cap.oldCost - 500).toString()
        } else {
            holder.tvOldCost.text = cap.oldCost.toString()
            holder.tvOldCost.setTextColor(R.color.custom_yellow)
            holder.tvNewCost.text = null
        }
        holder.ivCap.setImageResource(cap.image)
        if (cap.statusFavourites) holder.ivStatus.setImageResource(R.drawable.yellow_heart)
        holder.itemView.setOnClickListener {
            onCapItemClickListener?.invoke(cap)
        }
        holder.itemView.setOnLongClickListener {
            onCapItemLongClickListener?.invoke(cap)
            return@setOnLongClickListener true
        }
    }

    inner class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCompany: TextView = itemView.findViewById(R.id.tv_company_name_discount)
        val tvSeries: TextView = itemView.findViewById(R.id.tv_series_name_discount)
        val tvOldCost: TextView = itemView.findViewById(R.id.tv_old_cost_discount)
        val tvNewCost: TextView = itemView.findViewById(R.id.tv_new_cost_discount)
        val ivCap: ImageView = itemView.findViewById(R.id.iv_discount)
        val ivStatus: ImageView = itemView.findViewById(R.id.iv_status_discount)
    }
}