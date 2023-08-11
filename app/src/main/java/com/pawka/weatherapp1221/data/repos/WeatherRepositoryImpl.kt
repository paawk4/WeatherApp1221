package com.pawka.weatherapp1221.data.repos

import com.pawka.weatherapp1221.data.retrofit.RetrofitService
import com.pawka.weatherapp1221.domain.models.WeatherModel
import com.pawka.weatherapp1221.domain.repos.WeatherRepository
import com.pawka.weatherapp1221.domain.utils.Result

class WeatherRepositoryImpl(private val retrofitService: RetrofitService): WeatherRepository {
    override fun getWeather(): Result<WeatherModel> {
        return retrofitService.getWeather()
    }

}