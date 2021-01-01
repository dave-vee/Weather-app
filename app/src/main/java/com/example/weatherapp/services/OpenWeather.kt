package com.example.weatherapp.services

// Other imported classes


import com.example.weatherapp.data.Request
import com.example.weatherapp.data.Response
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class OpenWeather {
    private val service: WeatherService

    companion object {
        //1
        const val BASE_URL = "https://api.openweathermap.org/"
    }

    init {
        // 2
        val retrofit = Retrofit.Builder()
            // 1
            .baseUrl(BASE_URL)
            //3
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
        //4
        service = retrofit.create(WeatherService::class.java)
    }

    fun getClient(): OkHttpClient {
        val spec = ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
            .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
            .cipherSuites(
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA
            )
            .build()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
//            .connectionSpecs(Collections.singletonList(spec))
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()


    }

    suspend fun getData(city: String): Response {
        return service.searchData(city, Request.api)
    }

}
