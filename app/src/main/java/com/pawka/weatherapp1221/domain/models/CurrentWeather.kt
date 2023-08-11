package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class  CurrentWeather(
    @SerializedName("last_updated")
    val lastUpdated: String,
    val condition: Condition,
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("temp_c")
    val temp: Double,
    @SerializedName("wind_kph")
    val wind: Double,
)