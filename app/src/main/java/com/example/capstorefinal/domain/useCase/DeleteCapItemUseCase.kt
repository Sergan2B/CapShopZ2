package com.example.capstorefinal.domain.useCase

import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.repository.CapListRepository

class DeleteCapItemUseCase(private val capListRepository: CapListRepository) {
    suspend fun deleteShopItem(capItem: Cap) {
        capListRepository.deleteCapItem(capItem)
    }
}