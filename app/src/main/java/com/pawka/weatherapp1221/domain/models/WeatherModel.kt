package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    @SerializedName("forecast")
    val forecastWeather: ForecastWeather
)