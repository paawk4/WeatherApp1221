package com.pawka.weatherapp1221.presentation.viewmodels

import com.pawka.weatherapp1221.domain.models.WeatherModel
import com.pawka.weatherapp1221.domain.usecases.GetWeatherUseCase
import com.pawka.weatherapp1221.domain.utils.Result
import com.pawka.weatherapp1221.presentation.viewmodels.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainWeatherScreenViewModel(private val getWeather: GetWeatherUseCase) : BaseViewModel() {

    private var _currentWeather = MutableStateFlow<WeatherModel?>(null)
    val currentWeather = _currentWeather.asStateFlow()

    init {
        requestWeather()
    }

    fun requestWeather() = launch {
        when (val result = withContext(Dispatchers.IO) { getWeather() }) {
            is Result.Success -> {
                _currentWeather.value = result.data
            }

            is Result.Failure -> {

            }
        }
    }
}