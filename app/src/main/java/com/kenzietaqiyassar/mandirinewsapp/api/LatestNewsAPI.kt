package com.kenzietaqiyassar.mandirinewsapp.api

import com.kenzietaqiyassar.mandirinewsapp.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LatestNewsAPI {
    @GET("top-headlines")
    fun getRecentNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): retrofit2.Call<NewsResponse>
}