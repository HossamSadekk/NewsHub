package com.example.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class HttpDetectInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (response.networkResponse() != null) {
            Timber.d( "Response from networkResponse(): " + response.networkResponse())
        } else if (response.cacheResponse() != null) {
            Timber.d( "Response from cacheControl(): " + response.cacheResponse())
        }
        return response
    }
}