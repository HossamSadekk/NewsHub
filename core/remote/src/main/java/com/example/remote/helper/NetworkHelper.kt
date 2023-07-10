package com.example.remote.helper

import android.content.Context
import com.example.remote.interceptors.ApiKeyInterceptor
import com.example.remote.interceptors.HttpRequestInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit
private const val CLIENT_TIME_OUT = 60L


fun createHttpRequestInterceptor(): HttpRequestInterceptor {
    return HttpRequestInterceptor()
}

fun createApiKeyInterceptor(apiKey: String): ApiKeyInterceptor {
    return ApiKeyInterceptor(apiKey)
}

fun createOkHttpClient(
    apiKey: String
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        addInterceptor(createHttpRequestInterceptor())
        addInterceptor(createApiKeyInterceptor(apiKey))
        //specifies the maximum amount of time that OkHttp will wait for the server to respond to the connection request
        connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        //controls how long OkHttp will wait for the response data to be sent by the server.
        readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        //OkHttp will wait to send data to the server before giving up and throwing a SocketTimeoutException.
        writeTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
    }.build()
}
