package com.example.capstorefinal.domain.useCase

import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.repository.CapListRepository

class EditCapItemUseCase(private val capEditRepository: CapListRepository) {
    suspend fun editShopItem(capItem: Cap) {
        capEditRepository.editCapItem(capItem)
    }
}