package com.example.remote.helper

import android.content.Context
import com.example.remote.interceptors.ApiKeyInterceptor
import com.example.remote.interceptors.ForceAppCacheInterceptor
import com.example.remote.interceptors.HttpDetectInterceptor
import com.example.remote.interceptors.HttpRequestInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

/**Cache-control is a header used to specify caching policies in client requests and server responses.
 * **/

private const val CLIENT_CACHE_SIZE = 10 * 1024 * 1024L
private const val CLIENT_CACHE_DIRECTORY = "Okhttp-cache"
private const val CLIENT_TIME_OUT = 60L

fun createCache(context: Context): Cache = Cache(
    File(context.cacheDir, CLIENT_CACHE_DIRECTORY),
    CLIENT_CACHE_SIZE
)

fun createHttpRequestInterceptor(): HttpRequestInterceptor {
    return HttpRequestInterceptor()
}

fun createHttpDetectInterceptor(): HttpDetectInterceptor {
    return HttpDetectInterceptor()
}

fun createForceAppCacheInterceptor(context: Context): ForceAppCacheInterceptor {
    return ForceAppCacheInterceptor(context)
}

fun createApiKeyInterceptor(apiKey: String): ApiKeyInterceptor {
    return ApiKeyInterceptor(apiKey)
}

fun createOkHttpClient(
    isDev: Boolean,
    context: Context,
    apiKey: String
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        cache(createCache(context))
        if (isDev) {
            addInterceptor(createHttpDetectInterceptor())
        }
        addInterceptor(createHttpRequestInterceptor())
        addInterceptor(createForceAppCacheInterceptor(context))
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
