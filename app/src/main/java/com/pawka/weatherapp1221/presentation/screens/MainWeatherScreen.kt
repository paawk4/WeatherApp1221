package com.pawka.weatherapp1221.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pawka.weatherapp1221.presentation.viewmodels.MainWeatherScreenViewModel
import com.pawka.weatherapp1221.presentation.views.WeatherByDaysColumn
import com.pawka.weatherapp1221.presentation.views.WeatherCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainWeatherScreen(viewModel: MainWeatherScreenViewModel = koinViewModel()) {
    val weather = viewModel.currentWeather.collectAsState().value

    Column(modifier = Modifier.padding(5.dp)) {
        if (weather != null) {
            WeatherCard(weather = weather, onClickSync = { viewModel.requestWeather() })
            WeatherByDaysColumn(weather = weather)
        } else {

        }
    }
}



