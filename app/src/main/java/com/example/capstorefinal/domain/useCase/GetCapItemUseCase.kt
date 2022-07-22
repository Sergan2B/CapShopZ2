package com.example.capstorefinal.domain.useCase

import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.repository.CapListRepository

class GetCapItemUseCase(private val capListRepository: CapListRepository) {
    suspend fun getShopItem(capItemId: Int): Cap {
        return capListRepository.getCapItem(capItemId)
    }
}