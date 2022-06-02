package com.example.retrofitforecaster

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.room.Room
import com.example.retrofitforecaster.databinding.ListItemWeatherBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.logging.HttpLoggingInterceptor

interface ForecastAPI {
    @GET("data/2.5/forecast")
    suspend fun getHourlyForecastForNextDays(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
    ): Temperatures
}

val forecastApiService: ForecastAPI by lazy {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addNetworkInterceptor(LoggingInterceptor())
        .addInterceptor(httpLoggingInterceptor)
        .build()

    Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ForecastAPI::class.java)
}

