package com.pawka.weatherapp1221.presentation.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pawka.weatherapp1221.domain.models.WeatherModel

@Composable
fun WeatherByDaysColumn(weather: WeatherModel) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(weather.forecast.forecastDay) {
            WeatherDayItem(it)
        }
    }
}