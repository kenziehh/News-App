package com.kenzietaqiyassar.mandirinewsapp.api

import com.kenzietaqiyassar.mandirinewsapp.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AllNewsAPI {
    @GET("everything")
    fun getAllNews(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ): retrofit2.Call<NewsResponse>
}