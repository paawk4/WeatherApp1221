package com.pawka.weatherapp1221.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.pawka.weatherapp1221.presentation.utils.Status
import com.pawka.weatherapp1221.presentation.viewmodels.MainWeatherScreenViewModel
import com.pawka.weatherapp1221.presentation.views.WeatherByDaysColumn
import com.pawka.weatherapp1221.presentation.views.WeatherCard
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainWeatherScreen(viewModel: MainWeatherScreenViewModel = koinViewModel()) {
    val weather by viewModel.currentWeather.observeAsState()

    var refreshing by remember {
        mutableStateOf(false)
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = {
            viewModel.requestWeather()
        }
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            when (weather?.responseType) {
                Status.ERROR -> {
                    refreshing = false
                    Text(text = weather?.error.toString())
                }

                Status.LOADING -> {
                    refreshing = true
                }

                Status.SUCCESSFUL -> {
                    refreshing = false
                    weather?.data?.let {
                        WeatherCard(weather = it, onClickSync = { viewModel.requestWeather() })
                        WeatherByDaysColumn(weather = it)
                    }
                }

                else -> {}
            }
        }
    }
}



