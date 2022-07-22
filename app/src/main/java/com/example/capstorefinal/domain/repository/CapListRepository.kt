package com.example.capstorefinal.domain.repository

import androidx.lifecycle.LiveData
import com.example.capstorefinal.domain.model.Cap

interface CapListRepository {
    suspend fun addCapItem(shopItem: Cap)
    suspend fun deleteCapItem(shopItem: Cap)
    suspend fun editCapItem(shopItem: Cap)
    suspend fun getCapItem(shopItemId: Int): Cap

    fun getCapList(): LiveData<List<Cap>>
}