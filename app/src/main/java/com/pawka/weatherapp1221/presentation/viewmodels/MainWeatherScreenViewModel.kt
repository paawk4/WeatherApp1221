package com.pawka.weatherapp1221.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pawka.weatherapp1221.domain.models.WeatherModel
import com.pawka.weatherapp1221.domain.usecases.GetWeatherUseCase
import com.pawka.weatherapp1221.domain.utils.Result
import com.pawka.weatherapp1221.presentation.utils.Data
import com.pawka.weatherapp1221.presentation.utils.Status
import com.pawka.weatherapp1221.presentation.viewmodels.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainWeatherScreenViewModel(private val getWeather: GetWeatherUseCase) : BaseViewModel() {

    private var _currentWeather: MutableLiveData<Data<WeatherModel>> = MutableLiveData()
    val currentWeather: LiveData<Data<WeatherModel>>
        get() {
            return _currentWeather
        }
    init {
        requestWeather()
    }

    fun requestWeather() = launch {
        _currentWeather.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getWeather() }) {
            is Result.Success -> {
                _currentWeather.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }

            is Result.Failure -> {
                _currentWeather.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }
}