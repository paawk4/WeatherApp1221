package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("avghumidity")
    val avgHumidity: Double,
    @SerializedName("avgtemp_c")
    val avgTemp: Double,
    val condition: Condition,
    @SerializedName("maxwind_kph")
    val maxWind: Double
)