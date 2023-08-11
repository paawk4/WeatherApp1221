package com.pawka.weatherapp1221.data.retrofit

import com.pawka.weatherapp1221.domain.models.WeatherModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitServiceApi {

    @GET("forecast.json?&q=moscow&days=5&key=${API_KEY}")
    fun getWeather(): Call<WeatherModel>

    companion object {
        private const val API_KEY = "6368b3d05c944f9e9d8113827230902"
    }
}