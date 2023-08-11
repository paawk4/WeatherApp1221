package com.pawka.weatherapp1221.domain.models

import com.google.gson.annotations.SerializedName

data class ForecastDay(
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val day: Day,
)