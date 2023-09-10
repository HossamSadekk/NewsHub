package com.example.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.io.IOException

class HttpRequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url()).build()
        var response = chain.proceed(request)
        if (response.code() == 429) {
            throw IOException("Rate limit exceeded")
        }
        if (response.code() == 401) {
            throw IOException("Missing or Invalid Authentication Credentials")
        }
        response.close()
        Timber.d(request.toString())
        return chain.proceed(request)
    }
}