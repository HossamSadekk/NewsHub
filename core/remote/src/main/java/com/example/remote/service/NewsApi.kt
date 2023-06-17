package com.example.remote.service

import com.example.model.remote.ArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
    ): ArticlesResponse


    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val TOP_HEADLINES = "top-headlines"
    }

}