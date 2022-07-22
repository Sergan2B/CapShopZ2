package com.example.capstorefinal.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.capstorefinal.R
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.core.network.result.Resource
import com.example.capstorefinal.data.repository.CapListRepositoryImpl
import com.example.capstorefinal.domain.model.Banner
import com.example.capstorefinal.domain.model.Cap
import com.example.capstorefinal.domain.useCase.AddCapItemUseCase
import com.example.capstorefinal.domain.useCase.GetCapListUseCase
import com.example.capstorefinal.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel : BaseViewModel() {
    private val repositoryImpl = CapListRepositoryImpl()
    private val company = listOf("New Era", "Adidas", "Nike", "Vans")
    private val series = listOf("San Francisco", "Kuala-Lumpur", "New Your", "London")
    private val oldCost = listOf(3000, 2400, 4350, 1900, 2600, 3200, 2200, 4100)
    private val image = R.drawable.cap_flatcap

    private val addCapItemUseCase = AddCapItemUseCase(repositoryImpl)
    private val getCapListUseCase = GetCapListUseCase(repositoryImpl)
    val capListLD = getCapListUseCase.getCapList()

    fun getBanner(): LiveData<Resource<Banner>> {
        return App().repository.getBaner()
    }

    init {
        /*for (i in 0 until 20) {
            val item = Cap(
                company[Random.nextInt(company.size)],
                series[Random.nextInt(series.size)],
                oldCost[Random.nextInt(oldCost.size)],
                newCost = Random.nextBoolean(),
                image,
                statusFavourites = Random.nextBoolean(),
                statusBestsellers = Random.nextBoolean(),
                statusDiscount = Random.nextBoolean()
            )*/
        for (i in 0 until 20) {
            val item = Cap(
                company[1],
                series[1],
                oldCost[1],
                newCost = Random.nextBoolean(),
                image,
                statusFavourites = Random.nextBoolean(),
                statusBestsellers = Random.nextBoolean(),
                statusDiscount = Random.nextBoolean()
            )
            addCapItem(item)
        }
    }

    private fun addCapItem(capItem: Cap) {
        viewModelScope.launch(Dispatchers.IO) {
            addCapItemUseCase.addCapItem(capItem)
        }
    }
}

