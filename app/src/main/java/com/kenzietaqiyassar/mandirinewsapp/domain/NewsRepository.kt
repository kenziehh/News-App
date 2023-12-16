package com.kenzietaqiyassar.mandirinewsapp.domain

import android.util.Log
import com.kenzietaqiyassar.mandirinewsapp.adapter.NewsAdapter
import com.kenzietaqiyassar.mandirinewsapp.api.APIClient
import com.kenzietaqiyassar.mandirinewsapp.api.AllNewsAPI
import com.kenzietaqiyassar.mandirinewsapp.api.LatestNewsAPI
import com.kenzietaqiyassar.mandirinewsapp.databinding.FragmentHomeBinding
import com.kenzietaqiyassar.mandirinewsapp.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.kenzietaqiyassar.mandirinewsapp.model.Article


class NewsRepository {

    fun getRecentNews(onSuccess: (List<Article>) -> Unit, onFailure: (String) -> Unit) {
        val recentNews: LatestNewsAPI = APIClient.getClient().create(LatestNewsAPI::class.java)
        recentNews.getRecentNews("us", "9fe42690989b44bfb9261f7e7a295777")
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    if (response.isSuccessful) {
                        val articles = response.body()?.articles ?: emptyList()
                        onSuccess.invoke(articles.subList(0, 10))
                    } else {
                        onFailure.invoke("Failed to fetch recent news articles")
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.d("FETCH_ERROR", "Cannot fetch recent news articles")
                    onFailure.invoke("Failed to fetch recent news articles")
                }
            })
    }

    fun getAllNews(onSuccess: (List<Article>) -> Unit, onFailure: (String) -> Unit) {
        val allNews: AllNewsAPI = APIClient.getClient().create(AllNewsAPI::class.java)
        allNews.getAllNews("us", "9fe42690989b44bfb9261f7e7a295777")
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    if (response.isSuccessful) {
                        val articles = response.body()?.articles ?: emptyList()
                        onSuccess.invoke(articles)
                    } else {
                        onFailure.invoke("Failed to fetch all news articles")
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.d("FETCH_ERROR", "Cannot fetch all news articles")
                    onFailure.invoke("Failed to fetch all news articles")
                }
            })
    }
}
