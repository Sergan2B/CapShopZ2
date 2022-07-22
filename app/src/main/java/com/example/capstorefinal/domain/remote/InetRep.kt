package com.example.capstorefinal.domain.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstorefinal.core.network.result.Resource
import com.example.capstorefinal.domain.model.Banner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InetRep {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getBaner(): LiveData<Resource<Banner>> {
        val data = MutableLiveData<Resource<Banner>>()
        apiService.getBanner().enqueue(object : Callback<Banner> {
            override fun onResponse(call: Call<Banner>, response: Response<Banner>) {
                if (response.isSuccessful) {
                    if (response.body() != null)
                        data.value = Resource.success(response.body()!!)
                } else {
                    data.value = Resource.error(response.message(), null)
                }
            }

            override fun onFailure(call: Call<Banner>, t: Throwable) {
                data.value = Resource.error(t.message, null)
            }
        })
        return data
    }
}