package com.example.capstorefinal.presentation.ui.tabLayout

import androidx.lifecycle.LiveData
import com.example.capstorefinal.App
import com.example.capstorefinal.core.base.BaseViewModel
import com.example.capstorefinal.core.network.result.Resource
import com.example.capstorefinal.domain.model.Banner

class TabViewModel : BaseViewModel() {
    fun getBanner(): LiveData<Resource<Banner>> {
        return App().repository.getBaner()
    }
}