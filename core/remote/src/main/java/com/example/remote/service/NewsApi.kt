package com.example.remote.service

import com.example.model.remote.articles.ArticlesResponse
import com.example.model.remote.sources.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
    ): ArticlesResponse

    @GET(SOURCES)
    suspend fun getSources(): SourcesResponse


    @GET(EVERYTHING)
    suspend fun getArticles(
        @Query("q") query: String,
    ): ArticlesResponse


    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val TOP_HEADLINES = "top-headlines"
        const val SOURCES = "sources"
        const val EVERYTHING = "everything"
    }

}