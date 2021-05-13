package com.lucascabral.nasa_spacedaily.di

import com.lucascabral.nasa_spacedaily.network.NasaApiInterface
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

class NetworkTest: KoinTest {

    private val api: NasaApiInterface by inject()
    private val moshi: Moshi by inject()
    private val retrofit: Retrofit by inject()
    private val okHttpClient: OkHttpClient by inject()
    private val baseUrl: String by lazy { get(named("BASE_URL")) as String }

    @Before
    fun setup() {
        startKoin {
            modules(listOf(networkModule))
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `Test Retrofit Created`() {
        assertNotNull(retrofit)
        assert(baseUrl == "https://api.nasa.gov/planetary/")
    }

    @Test
    fun `Test OkHttp`() {
        assertNotNull(okHttpClient)
        assertTrue(okHttpClient.connectTimeoutMillis == 30000)
        assertTrue(okHttpClient.writeTimeoutMillis == 30000)
        assertTrue(okHttpClient.readTimeoutMillis == 30000)
        assertTrue(okHttpClient.interceptors.size == 1)
    }

    @Test
    fun `Test Api Created`() {
        assertNotNull(api)
    }

    @Test
    fun `Test Moshi Created`() {
        assertNotNull(moshi)
    }
}