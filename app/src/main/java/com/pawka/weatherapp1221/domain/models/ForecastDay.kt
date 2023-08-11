package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class ForecastDay(
    val date: String,
    @SerializedName("day")
    val forecast: Forecast,
)