package com.example.capstorefinal.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.capstorefinal.domain.model.Cap

class ShopItemDiffCallback : DiffUtil.ItemCallback<Cap>() {
    override fun areItemsTheSame(oldItem: Cap, newItem: Cap): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cap, newItem: Cap): Boolean {
        return oldItem == newItem
    }
}