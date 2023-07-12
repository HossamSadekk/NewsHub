package com.example.feed.data.repository

import com.example.remote.service.NewsApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

class FeedRepositoryImplTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: NewsApi
    private lateinit var client: OkHttpClient
    private lateinit var feedRepositoryImpl: FeedRepositoryImpl


    @Test
    fun `should fetch top headlines correctly given 200 response`() = runBlocking {
        mockWebServer.enqueueResponse("top-headlines.json",200)
        val result = feedRepositoryImpl.getTopHeadlines("us", 20, 1)
        assertNotNull(result.articles)
    }

    @Test
    fun `should not fetch top headlines if code is 500`() = runBlocking {
        mockWebServer.enqueueResponse("top-headlines.json",500)
        val result = runCatching { feedRepositoryImpl.getTopHeadlines("us", 20, 1)  }
        assertTrue(result.isFailure)
    }



    private fun MockWebServer.enqueueResponse(fileName: String, code: Int) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)

        val source = inputStream?.let { inputStream.source().buffer() }
        source?.let {
            enqueue(
                MockResponse()
                    .setResponseCode(code)
                    .setBody(source.readString(StandardCharsets.UTF_8))
            )
        }
    }

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NewsApi::class.java)

        feedRepositoryImpl = FeedRepositoryImpl(api)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}