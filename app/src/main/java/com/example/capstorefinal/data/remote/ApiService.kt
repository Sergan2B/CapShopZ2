package com.example.capstorefinal.data.remote

import com.example.capstorefinal.data.model.CapModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("caps")
    fun getCaps(
        @Query("format") format:String = "json"
    ): Call<List<CapModel>>
}