package com.example.capstorefinal.domain.useCase

import androidx.lifecycle.LiveData
import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.repository.CapListRepository

class GetCapListUseCase(private val capListRepository: CapListRepository) {

    fun getCapList(): LiveData<List<Cap>> {
        return capListRepository.getCapList()
    }
}