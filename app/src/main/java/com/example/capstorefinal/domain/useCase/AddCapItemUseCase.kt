package com.example.capstorefinal.domain.useCase

import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.repository.CapListRepository

class AddCapItemUseCase(private val capListRepository: CapListRepository) {
    suspend fun addCapItem(capItem: Cap) {
        capListRepository.addCapItem(capItem)
    }
}