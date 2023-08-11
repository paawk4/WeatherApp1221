package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int,
    val condition: Condition,
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("temp_c")
    val temp: Double,
    @SerializedName("wind_kph")
    val wind: Double,
)