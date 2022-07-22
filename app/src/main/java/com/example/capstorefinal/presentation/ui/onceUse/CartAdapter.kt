package com.example.capstorefinal.presentation.ui.onceUse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.capstorefinal.R
import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.presentation.ui.onceUse.CartAdapter.ViewHolder
import com.example.capstorefinal.utils.ShopItemDiffCallback

class CartAdapter : ListAdapter<Cap, ViewHolder>(ShopItemDiffCallback()) {
    var onCapItemClickListener: ((Cap) -> Unit)? = null
    var onCapMinusCountClickListener: ((Int) -> Unit)? = null
    var onCapPlusCountClickListener: ((Int) -> Unit)? = null
    var onCapDeleteClickListener: ((Cap) -> Unit)? = null
    var onCapItemLongClickListener: ((Cap) -> Unit)? = null
    private var tvCartCountInt = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = R.layout.list_of_cart_shop
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cap = getItem(position)
        holder.tvCompany.text = cap.companyName
        holder.tvSeries.text = cap.seriesName
        holder.tvCost.text = cap.oldCost.toString()

        holder.tvCartCount.text = tvCartCountInt.toString()

        holder.ivCap.setImageResource(cap.image)
        holder.tvSize.text = "M"

        holder.ivMinus.setOnClickListener {
            onCapMinusCountClickListener?.invoke(tvCartCountInt--)
            holder.tvCartCount.text = tvCartCountInt.toString()
        }
        holder.ivPlust.setOnClickListener {
            onCapMinusCountClickListener?.invoke(tvCartCountInt++)
            holder.tvCartCount.text = tvCartCountInt.toString()
        }

        holder.ivTrash.setOnClickListener {
            onCapDeleteClickListener?.invoke(cap)
        }

        holder.itemView.setOnLongClickListener {
            onCapItemLongClickListener?.invoke(cap)
            return@setOnLongClickListener true
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCompany: TextView = itemView.findViewById(R.id.tv_company_name)
        val tvSeries: TextView = itemView.findViewById(R.id.tv_series_name)
        val tvCost: TextView = itemView.findViewById(R.id.tv_cost)
        val ivCap: ImageView = itemView.findViewById(R.id.iv_cap)
        val ivTrash: ImageView = itemView.findViewById(R.id.iv_trash)
        val ivMinus: ImageView = itemView.findViewById(R.id.iv_minus)
        val ivPlust: ImageView = itemView.findViewById(R.id.iv_plus)
        val tvCartCount: TextView = itemView.findViewById(R.id.tv_cart_count)
        val tvSize: TextView = itemView.findViewById(R.id.tv_size)
    }
}