package com.example.capstorefinal.domain.remote

import com.example.capstorefinal.domain.model.Banner
import com.example.capstorefinal.domain.model.Cap
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("baner")
    fun getBanner() : Call<Banner>

    @GET("playlists")
    fun getCap(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResult: Int,
    ): Call<Cap>

    @GET("playlistItems")
    fun getDetailPLayList(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") key: String,
        @Query("maxResults") maxResult: Int,
    ): Call<Cap>
}