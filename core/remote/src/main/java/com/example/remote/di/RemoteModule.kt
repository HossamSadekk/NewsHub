package com.example.remote.di

import android.content.Context
import com.example.remote.helper.createOkHttpClient
import com.example.remote.service.NewsApi
import com.example.remote.service.NewsApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        @Named(value = "isDebug") isDev: Boolean,
        @Named(value = "API_KEY") apiKey: String
    ): OkHttpClient {
        return createOkHttpClient(
            context = context,
            isDev = isDev,
            apiKey = apiKey
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit):NewsApi =
        retrofit.create(NewsApi::class.java)
}