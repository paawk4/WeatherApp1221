package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class ForecastWeather(
    @SerializedName("forecastday")
    val forecastDay: List<ForecastDay>
)