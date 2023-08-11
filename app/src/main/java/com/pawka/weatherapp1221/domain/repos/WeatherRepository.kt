package com.pawka.weatherapp1221.domain.repos

import com.pawka.weatherapp1221.domain.models.WeatherModel
import com.pawka.weatherapp1221.domain.utils.Result

interface WeatherRepository {

    fun getWeather(): Result<WeatherModel>
}