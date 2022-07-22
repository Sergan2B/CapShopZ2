package com.example.capstorefinal.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.repository.CapListRepository

class CapListRepositoryImpl : CapListRepository {

    private val shopList = sortedSetOf<Cap>({ element1, element2 -> element1.id.compareTo(element2.id) })
    private val shopListLD = MutableLiveData<List<Cap>>()

    private var autoIncrementId = 0

    override suspend fun addCapItem(shopItem: Cap) {
        if (shopItem.id == Cap.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override suspend fun deleteCapItem(shopItem: Cap) {
        shopList.remove(shopItem)
        updateList()
    }

    override suspend fun getCapItem(shopItemId: Int): Cap { //= shopList[shopItemId]
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with ID $shopItemId not found")
    }

    override suspend fun editCapItem(shopItem: Cap) {

    }

    override fun getCapList(): LiveData<List<Cap>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.postValue(shopList.toList())
    }
}