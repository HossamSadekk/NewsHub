package com.example.remote.di

import android.content.Context
import com.example.remote.helper.createOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        @Named(value = "isDebug") isDev: Boolean
    ): OkHttpClient {
        return createOkHttpClient(
            context = context,
            isDev = isDev
        )
    }
}