package com.example.remote.interceptors

import android.content.Context
import com.example.remote.helper.isInternetAvailable
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ForceAppCacheInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        if (!context.isInternetAvailable()) {
            /**
             * CacheControl.FORCE_CACHE is a flag that can be used to force
             * OkHttp to return a cached response without making a network request.
             * This can be useful in scenarios where the client is offline or the network connection is unreliable.
             * **/
            builder.cacheControl(CacheControl.FORCE_CACHE);
        }
        return chain.proceed(builder.build());
    }
}