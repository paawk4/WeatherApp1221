package com.pawka.weatherapp1221.data.retrofit

import com.pawka.weatherapp1221.domain.models.WeatherModel
import com.pawka.weatherapp1221.domain.utils.Result

class RetrofitService {
    private val api = RetrofitInstance.create()

    fun getWeather(): Result<WeatherModel> {
        val callResponse = api.getWeather()
        try {
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.Success(it)
                }
            }
            return Result.Failure(Exception(response.message()))
        } catch (_: Exception) {
            return Result.Failure(Exception("no internet connection"))
        }
    }
}